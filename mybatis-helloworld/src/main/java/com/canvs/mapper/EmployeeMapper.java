package com.canvs.mapper;

import com.canvs.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeMapper {
    List<Employee> getEmployees();
    Employee getEmployeeById(int id);
    int insertEmployee(Employee employee);
    void updateEmployee(@Param("empId") int empId,@Param("empSalary") double empSalary);
    int updateEmployeeByMap(Map<String, Object> paramMap);
    int getEmployeeCount();
    Map<String,Object> getEmpNameAndMaxSalary();
}
