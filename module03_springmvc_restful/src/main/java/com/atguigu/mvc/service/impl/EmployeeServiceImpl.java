package com.atguigu.mvc.service.impl;

import com.atguigu.mvc.dao.EmployeeDAO;
import com.atguigu.mvc.pojo.Employee;
import com.atguigu.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: EmployeeServiceImpl
 * Package: com.atguigu.mvc.service.impl
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/6 - 21:50  21:50
 * @Version: v1.0
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //根据类型进行属性 注入EmployeeDAO类型 属性
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public Integer addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    public Integer deleteEmpById(Integer empId) {
        return employeeDAO.deleteEmpById(empId);
    }

    @Override
    public Integer updateEmp(Employee emp) {
        return employeeDAO.updateEmp(emp);
    }

    @Override
    public Employee queryById(Integer empId) {
        return employeeDAO.queryById(empId);
    }

    @Override
    public List<Employee> list() {
        return employeeDAO.list();
    }

    @Override
    public Integer count() {
        return employeeDAO.count();
    }
}
