package com.atguigu.maven.test;

import com.atguigu.maven.pojo.HelloMaven;
import org.junit.Test;

/**
 * ClassName: TestHelloMaven
 * Package: com.atguigu.maven.test
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/7 - 12:47  12:47
 * @Version: v1.0
 */


public class TestHelloMaven {

    @Test
    public void testHelloMaven(){
        new HelloMaven().helloMaven();
    }

}
