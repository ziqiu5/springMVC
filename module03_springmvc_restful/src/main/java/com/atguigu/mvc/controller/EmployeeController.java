package com.atguigu.mvc.controller;

import com.atguigu.mvc.pojo.Employee;
import com.atguigu.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: restfulController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/6 - 21:29  21:29
 * @Version: v1.0
 */

@Controller
public class EmployeeController {

    //根据属性类型进行注入
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String addEmp(Model model) {
        //调用employeeService中的list方法 获取员工信息集合
        List<Employee> employeeList = employeeService.list();
        //将集合放入model模型中去 即存入request域中
        model.addAttribute("employeeList", employeeList);
        return "emp/emp_info";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/emp";
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.DELETE)
    public String delEmp(@PathVariable("empId") Integer empId) {
        employeeService.deleteEmpById(empId);
        return "redirect:/emp";
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.GET)
    public String queryById(@PathVariable("empId") Integer empId, Model model) {
        Employee employee = employeeService.queryById(empId);
        model.addAttribute("emp", employee);
        return "emp/update_emp";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String updateEmp(Employee emp){
        employeeService.updateEmp(emp);
        return "redirect:emp";
    }


}
