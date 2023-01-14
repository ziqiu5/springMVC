package com.atguigu.mvc.pojo;

import java.math.BigDecimal;

/**
 * ClassName: Employee
 * Package: com.atguigu.mvc.pojo
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/6 - 21:40  21:40
 * @Version: v1.0
 */


public class Employee {
    private Integer empId;
    private String name;
    private String sex;
    private BigDecimal sal;

    public Employee() {
    }

    public Employee(Integer empId, String name, String sex, BigDecimal sal) {
        this.empId = empId;
        this.name = name;
        this.sex = sex;
        this.sal = sal;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", sal=" + sal +
                '}';
    }
}
