package com.atguigu.mvc.dao;

import com.atguigu.mvc.pojo.Employee;

import java.util.List;

/**
 * ClassName: EmployeeDAO
 * Package: com.atguigu.mvc.dao
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/6 - 21:52  21:52
 * @Version: v1.0
 */


public interface EmployeeDAO {

    Integer addEmployee(Employee employee);

    Integer deleteEmpById(Integer empId);

    Integer updateEmp(Employee emp);

    Employee queryById(Integer empId);

    List<Employee> list();

    Integer count();
}
