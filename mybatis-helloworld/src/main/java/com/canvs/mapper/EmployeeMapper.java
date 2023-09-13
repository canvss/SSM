package com.canvs.mapper;

import com.canvs.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getEmployees();
    Employee getEmployeeById(int id);
}
