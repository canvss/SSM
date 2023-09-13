### MyBatis

MyBatis最初是Apache的一个开源项目iBatis，2010年6月这个项目由Apache Software Foundation迁移到了Google Code。随着开发团队转投Google Code旗下，iBatis3.x正式更名为MyBatis。代码于2013年11月迁移到Github。

MyBatis是一款优秀的持久层框架，它支持自定义SQL、存储过程以及高级映射。MyBatis免除了几乎所有的JDBC代码以及设置参数和获取结果集的工作。MyBatis可以通过简单的XML或注解来配置和映射原始类型、接口和Java POJO(Plain Old Java Object，普通老式Java对象)为数据库中的记录。

#### 持久层框架对比

JDBC

- SQL夹杂在Java代码中耦合度高，导致硬编码内伤
- 维护不易且实际开发需求中SQL有变化，频繁修改的情况多见
- 代码冗长，开发效率低

Hibernate和JPA

- 操作简单，开发效率高
- 程序中的长难度复杂SQL需要绕过框架
- 内部自动生成的SQL。不容易做特殊优化
- 基于全映射的全自动框架，大量字段的POJO进行部门映射时比较困难。
- 反射操作太多，导致数据库性能下降

MyBatis

- 轻量级、性能出色
- SQL和Java编码分开，功能边界清晰。Java代码专注业务、SQL语句专注数据
- 开发效率稍逊于Hibernate

#### 快速入门

创建数据库和表

```sql
CREATE DATABASE `mybatis-example`;

USE `mybatis-example`;

CREATE TABLE `t_emp`(
  emp_id INT AUTO_INCREMENT,
  emp_name CHAR(100),
  emp_salary DOUBLE(10,5),
  PRIMARY KEY(emp_id)
);

INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("tom",200.33);
INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("jerry",666.66);
INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("andy",777.77);
```

依赖

```xml
<dependencies>
  <!-- mybatis依赖 -->
  <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.11</version>
  </dependency>

  <!-- MySQL驱动 mybatis底层依赖jdbc驱动实现,本次不需要导入连接池,mybatis自带! -->
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.25</version>
  </dependency>

  <!--junit5测试-->
  <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <version>5.3.1</version>
  </dependency>
</dependencies>
```

POJO类

```java
public class Employee {
    private int empId;
    private String empName;
    private double empSalary;
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public double getEmpSalary() {
        return empSalary;
    }
    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}
```

Mapper接口

Mybatis中的Mapper接口相当于以前DAO。但是区别于Mapper仅仅只是创建接口即可，我们不需要提供实现类，具体的SQL写到对应的Mapper文件

![](imgs/541894121584157.png)

```java
public interface EmployeeMapper {
    List<Employee> getEmployees();
    Employee getEmployeeById(int id);
}
```

Mapper xml 

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace等于mapper接口类的全限定名,这样实现对应 -->
<mapper namespace="com.canvs.mapper.EmployeeMapper">
    <select id="getEmployeeById" resultType="com.canvs.pojo.Employee">
        SELECT emp_id empId,emp_name empName,emp_salary empSalary FROM t_emp WHERE emp_id = #{id}
    </select>
    <select id="getEmployees" resultType="com.canvs.pojo.Employee">
        SELECT emp_id empId,emp_name empName,emp_salary empSalary FROM t_emp
    </select>
</mapper>
```

> 注意：
>
> - 方法名和SQL的id一致
> - 方法返回值和resultType一致
> - 方法的参数和SQL的参数一致
> - 接口的全类名和映射配置文件的名称空间一致

MyBatis配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
<!-- 表示配置Mybatis的开发环境，可以配置多个环境，default属性指定运行时使用的环境。default属性的取值是environment标签id属性的值   -->
    <environments default="development">
<!--  environment表示配置MyBatis的一个具体的环境      -->
        <environment id="development">
    <!--  Mybatis的内置事务管理器   -->
            <transactionManager type="JDBC"/>
            <!-- 建立数据库连接的具体信息 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/mybatis-example"/>
                <property name="username" value="root"/>
                <property name="password" value="canvs"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--
            Mapper注册：指定Mybatis映射文件的具体位置
            mapper标签：配置一个具体的Mapper映射文件
            resource属性：指定Mapper映射文件的实际存储位置，这儿以类路径为跟目录
            Maven工程的目录结构来说，resource目录下的内容会直接放入类路径
        -->
        <mapper resource="mappers/EmployeeMapper.xml"/>
    </mappers>
</configuration>
```

测试

```java
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
```

> - SqlSession：代表Java程序和数据库之间的会话。（HttpSession是Java程序和浏览器之间的会话）
> - SqlSessionFactory：是生产SqlSession的工厂
> - 工厂模式：如果创建某一个类对象。使用的过程基本固定，那么就可以把创建这个对象的相关代码封装到一个工程类中，以后都使用这个工厂类来生产我们需要的对象

**SqlSession和HttpSession区别**

- HttpSession：工作在Web服务器上，属于表述层
  - 代表浏览器和Web服务器之间的会话。
- SqlSession：不依赖Web服务器，属于持久化层
  - 代表Java程序和数据库之间的会话

![](imgs/5841618515658.png)

### MyBatis基本使用

#### 向SQL语句传参

##### mybatis日志输出配置

```xml
<settings>
  <!-- SLF4J 选择slf4j输出！ -->
  <setting name="logImpl" value="SLF4J"/>
</settings>
```

##### #{}形式

MyBatis会将SQL语句中的#{}转换为问号占位符

##### ${}形式

底层Mybatis做的是字符串拼接操作。会存在SQL注入问题

#### 数据输入

![](imgs/51155145545.png)

- 简单类型：只包含一个值的数据类型
  - 基本数据类型：int、byte、short、double....
  - 基本数据类型的包装类：Integer、Character、Double....
  - 字符串类型：String
- 复杂类型：包含多个值的数据类型
  - 实体类类型：Employee、Department、....
  - 集合类型：List、Set、Map...
  - 数组类型：int[]、String[]....
  - 复合类型：List\<Employee>、实体类中包含集合....

##### 单个简单类型参数

```java
Employee getEmployeeById(int id);
```

```xml
<select id="getEmployeeById" resultType="com.canvs.pojo.Employee">
    SELECT emp_id empId,emp_name empName,emp_salary empSalary FROM t_emp WHERE emp_id = #{id}
</select>
```

##### 实体类类型参数

Mapper接口中抽象方法的声明

```java
 void insertEmployee(Employee employee);
```

```xml
    <insert id="insertEmployee">
        INSERT INTO t_emp(emp_name,emp_salary) VALUES(#{empName},#{empSalary})
    </insert>
```

> Mybatis会根据#{}中传入的数据，加工成getXxx()方法，通过反射在实体类对象中调用这个方法，从而获取到对应的数据。填充到#{}解析后的问号占位符这个位置。

##### 零散的简单类型数据

```java
void updateEmployee(@Param("empId") int empId,@Param("empSalary") double empSalary);
```

```xml
    <update id="updateEmployee">
        UPDATE t_emp SET emp_salary=#{empSalary} WHERE emp_id=#{empId}
    </update>
```

##### Map类型参数

#{}中写Map中的key

```java
int updateEmployeeByMap(Map<String, Object> paramMap);
```

```xml
   <update id="updateEmployeeByMap">
        UPDATE t_emp SET emp_salary=#{empSalary} WHERE emp_id=#{empId}
    </update>
```

```java
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
    public void clear(){
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test5(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("empId",1);
        map.put("empSalary",0);
        int i = employeeMapper.updateEmployeeByMap(map);
        System.out.println(i);
    }
}
```

#### 数据输出

数据输出总体有两种形式：

- 增删改操作返回的受影响的行数：直接使用int或者long类型接收即可
- 查询操作的查询结果

##### 单个简单类型

mapper接口的抽象方法

```java
int getEmployeeCount();
```

xml配置

```xml
    <select id="getEmployeeCount" resultType="int">
        SELECT COUNT(*) FROM t_emp
    </select>
```

> Mybatis内部给常用的数据类型设定了很多别名。以int类型为例，可以写的名称有int、integer、Integer、Int等等

测试

```java
    public void test6(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int employeeCount = employeeMapper.getEmployeeCount();
        System.out.println(employeeCount);
    }
```

> 注意：
>
> select标签，通过resultType指定查询返回值类型
>
> resultType = 全限定符|别名｜如果是返回集合类型，写范型类即可

##### 别名问题

官方文档：https://mybatis.org/mybatis-3/zh/configuration.html#typeAliases

类型别名可为Java类型设置一个缩写名字，它仅用于XML配置，意在降低冗余的权限定类名

```xml
<typeAliases>
  <typeAlias alias="Author" type="domain.blog.Author"/>
  <typeAlias alias="Blog" type="domain.blog.Blog"/>
</typeAliases>
```

也可以指定一个包名，MyBatis会在包名下面搜索需要的Java Bean

```xml
<typeAliases> <package name="domain.blog"/> </typeAliases>
```

每一个在包domain.blog中的JavaBean，在没有注解的情况下，会使用Bean的首字母小写的非限定类名来作为它的别名。domain.blog.Author的别名为auther；若有注解，则别名为其注解值

```java
@Alias("author")
public class Author {
    ...
}
```

##### 返回实体类对象

Mapper接口的抽象方法

```java
Employee getEmployeeById(int id);
```

mapper配置文件sql

```xml
   <select id="getEmployeeById" resultType="com.canvs.pojo.Employee">
        SELECT emp_id empId,emp_name empName,emp_salary empSalary FROM t_emp WHERE emp_id = #{id}
    </select
```

通过给数据库表字段加别名，让查询结果的每一列都和Java实体类中的属性对应起来。增加全局配置自动识别对应关系。

在Mybatis全局配置文件中，做了下面的配置，select语句可以不给字段设置别名；开启自动映射驼峰式命名规则

```xml
<!-- 在全局范围内对Mybatis进行配置 -->
<settings>
  <!-- 具体配置 -->
  <!-- 从org.apache.ibatis.session.Configuration类中可以查看能使用的配置项 -->
  <!-- 将mapUnderscoreToCamelCase属性配置为true，表示开启自动映射驼峰式命名规则 -->
  <!-- 规则要求数据库表字段命名方式：单词_单词 -->
  <!-- 规则要求Java实体类属性名命名方式：首字母小写的驼峰式命名 -->
  <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```

##### 返回Map类型

适用于SQL查询返回的各个字段综合起来并不合任何一个现有的实体类对应，没法封装到实体类对象中。

Mapper接口的抽象方法

```java
 Map<String,Object> getEmpNameAndMaxSalary();
```

mapper配置SQL

```xml
    <select id="getEmpNameAndMaxSalary" resultType="map">
        SELECT emp_name,emp_salary FROM t_emp WHERE emp_salary IN (
        SELECT max(emp_salary) FROM t_emp
        )
    </select>
```

测试

```java
 public void test07() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Map<String, Object> empNameAndMaxSalary = employeeMapper.getEmpNameAndMaxSalary();
        Set<Map.Entry<String, Object>> entries = empNameAndMaxSalary.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
```

##### 返回List类型

查询结果返回多个实体类对象，希望把多个实体类对象放在List集合中返回。此时不需要任何特殊处理，在resultType属性中还是设置实体类类型即可

Mapper接口中的抽象方法

```java
List<Employee> getEmployees();
```

Mapper配置SQL

```xml
    <select id="getEmployees" resultType="employee">
        SELECT emp_id empId,emp_name empName,emp_salary empSalary FROM t_emp
    </select>
```

测试

```java
    public void test08(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.getEmployees();
        employees.forEach(System.out :: println);
    }
```

##### 返回主键值

自增长类型主键

Mapper接口中的方法

```java
int insertEmployee(Employee employee);
```

Mapper配置文件SQL

```xml
    <insert id="insertEmployee" useGeneratedKeys="true" keyProperty="empId">
        INSERT INTO t_emp(emp_name,emp_salary) VALUES(#{empName},#{empSalary})
    </insert>
```

测试

```java
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
```

注意：Mybatis是将自增主键的值设置到实体类对象中，而不是以Mapper接口方法返回值的形式返回。

##### 实体类属性和数据库字段对应关系

resultMap标签定义对应关系，再在后面的SQL语句中引用这个对应关系

```xml
    <resultMap id="EmployeeByRMResultMap" type="com.canvs.pojo.Employee">
        <id column="emp_id" property="empId"/>
        <id column="emp_name" property="empName"/>
        <id column="emp_salary" property="empSalary"/>
    </resultMap>

    <select id="getEmployees" resultType="EmployeeByRMResultMap">
        SELECT * empSalary FROM t_emp
    </select>
```

