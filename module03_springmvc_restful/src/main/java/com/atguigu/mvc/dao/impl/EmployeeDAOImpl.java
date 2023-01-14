package com.atguigu.mvc.dao.impl;

import com.atguigu.mvc.dao.EmployeeDAO;
import com.atguigu.mvc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: EmployeeDAOImpl
 * Package: com.atguigu.mvc.dao.impl
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/6 - 21:52  21:52
 * @Version: v1.0
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //属性注入 JdbcTemplate 类型属性
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer addEmployee(Employee employee) {
        String sql = "INSERT INTO `employee`(`name`,`sex`,`sal`) VALUES(?,?,?)";
        Object[] args = new Object[]{employee.getName(), employee.getSex(), employee.getSal()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Integer deleteEmpById(Integer empId) {
        String sql = "delete from `employee` where `empId` = ?";
        return jdbcTemplate.update(sql, empId);
    }

    @Override
    public Integer updateEmp(Employee emp) {
        String sql = "update `employee` set `name` = ?,`sex` = ?,`sal` = ? where `empId` = ?";
        Object[] args = new Object[]{emp.getName(), emp.getSex(), emp.getSal(), emp.getEmpId()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Employee queryById(Integer empId) {
        String sql = "select * from `employee` where `empId` = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), empId);
    }

    @Override
    public List<Employee> list() {
        String sql = "select * from `employee`";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Integer count() {
        String sql = "select count(*) from `employee`";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
