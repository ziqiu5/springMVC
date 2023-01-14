package com.atguigu.mvc.service;

import com.atguigu.mvc.pojo.Employee;

import java.util.List;

/**
 * ClassName: EmployeeService
 * Package: com.atguigu.mvc.service
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/6 - 21:48  21:48
 * @Version: v1.0
 */


public interface EmployeeService {

    Integer addEmployee(Employee employee);

    Integer deleteEmpById(Integer empId);

    Integer updateEmp(Employee emp);

    Employee queryById(Integer empId);

    List<Employee> list();

    Integer count();

}
