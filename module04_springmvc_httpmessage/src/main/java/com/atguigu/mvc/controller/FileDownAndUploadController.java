package com.atguigu.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * ClassName: FileDownAndUploadController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/8 - 13:36  13:36
 * @Version: v1.0
 */

@Controller
public class FileDownAndUploadController {

    @RequestMapping("/fileDown")
    public ResponseEntity<byte[]> fileDown(HttpSession session) throws IOException {
        //获取ServletContext 对象
        ServletContext servletContext = session.getServletContext();
        //获取要响应到浏览器中的文件路径
        String filePath = servletContext.getRealPath("/video/1.mp4");
        //获取输入流
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //创建字节数组 用于读取文件中的数据
        byte[] buf = new byte[fileInputStream.available()];
        //读取文件中的数据
        fileInputStream.read(buf);
        //创建响应头对象
        MultiValueMap<String, String> responseHeaders = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        responseHeaders.add("Content-Disposition", "attachment;filename=1.mp4");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(buf, responseHeaders, statusCode);
        //关闭输入流
        fileInputStream.close();
        return responseEntity;

    }

    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile multipartFile, HttpSession session) throws IOException {
        //获取文件上传的文件名
        String originalFilename = multipartFile.getOriginalFilename();
        //使用拼接文件名 让上传的文件名保存在服务器中时名字不重复
        //1.得到上传文件名的前缀
        String prefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        //2.得到上传文件名的后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //3.使用 UUID拼接文件名
        String fileName = prefix + UUID.randomUUID().toString() + suffix;

        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取真正工程路径
        String photo = servletContext.getRealPath("/photo");

        //若工程路径下的/photo文件不存在则创建
        File file = new File(photo);
        if (!file.exists()) {
            file.mkdir();
        }
        //最终路径
        String savPath = photo + File.separator + fileName;
        //将传入的文件数据保存到最终路径
        multipartFile.transferTo(new File(savPath));
        return "target";
    }


}
