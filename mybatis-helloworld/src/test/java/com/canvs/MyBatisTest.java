package com.canvs;

import com.canvs.mapper.EmployeeMapper;
import com.canvs.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void test() throws IOException {
        //以输入流形式加载MyBatis配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //基于读取MyBatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用SqlSessionFactory对象开启一个会话
        SqlSession sqlSession = sessionFactory.openSession();
        //根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象（动态代理技术）
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = employeeMapper.getEmployeeById(2);
        System.out.println(emp);
        List<Employee> employees = employeeMapper.getEmployees();
        employees.forEach(System.out :: println);
        sqlSession.commit();
        sqlSession.close();
    }
}
