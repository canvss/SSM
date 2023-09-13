package com.canvs;

import com.canvs.mapper.EmployeeMapper;
import com.canvs.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyBatisTest {
    private SqlSession sqlSession;

    @BeforeEach //junit5会在每一个@Test方法前执行@BeforeEach方法
    public void init() throws IOException {
        //以输入流形式加载MyBatis配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //基于读取MyBatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用SqlSessionFactory对象开启一个会话
        sqlSession = sessionFactory.openSession();
    }

    @AfterEach  //junit5会在每一个@Test方法后执行@@AfterEach方法
    public void clear() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test() {
        //根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象（动态代理技术）
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = employeeMapper.getEmployeeById(2);
        System.out.println(emp);
        List<Employee> employees = employeeMapper.getEmployees();
        employees.forEach(System.out::println);
    }

    @Test
    public void test02() {
        //根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象（动态代理技术）
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("endless");
        employee.setEmpSalary(1111.1);
        System.out.println(employee.getEmpId());
        System.out.println("-----");
        employeeMapper.insertEmployee(employee);
        System.out.println(employee.getEmpId());
    }

    @Test
    public void test04() {
        //根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象（动态代理技术）
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.updateEmployee(2, 88888);
    }

    @Test
    public void test5() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("empId", 1);
        map.put("empSalary", 0);
        int i = employeeMapper.updateEmployeeByMap(map);
        System.out.println(i);
    }

    @Test
    public void test6() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int employeeCount = employeeMapper.getEmployeeCount();
        System.out.println(employeeCount);
    }

    @Test
    public void test07() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map<String, Object> empNameAndMaxSalary = employeeMapper.getEmpNameAndMaxSalary();
        Set<Map.Entry<String, Object>> entries = empNameAndMaxSalary.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @Test
    public void test08(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.getEmployees();
        employees.forEach(System.out :: println);
    }
}
