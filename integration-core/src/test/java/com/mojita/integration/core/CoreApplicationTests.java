package com.mojita.integration.core;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mojita.integration.core.entity.Student;
import com.mojita.integration.core.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private StudentServiceImpl studentService;

	@Test
	public void testStudent() {
		Student student = new Student();
		student.setPassword("123");
		student.setUsername("张三");
//		studentService.addStudent(student);
	}

	@Test
	public void testAddStudentMysql() {
		Student student = new Student();
		student.setPassword("12233");
		student.setUsername("张三");
		studentService.addStudentMysql(student);
	}

	@Test
	public void testStudentMysql() {
//		Student student = new Student();
//		student.setId(1);
//		student.setPassword("123");
//		student.setUsername("张三");
		Student student = studentService.selectStudentMysql(1);
		System.out.println("mysqlSlave:" + student.toString());
	}

	@Test
	public void testSelectStudentPostgres() {
//		Student student = new Student();
//		student.setId(1);
//		student.setPassword("123");
//		student.setUsername("张三");
		List<Student> student = studentService.selectStudentAll();
		System.out.println("postgres:" + student.toString());
	}


	//测试baseMapper
	@Test
	public void testSelectStudentOne() {
		Student student = new Student();
		student.setId(1);
		Student student1 = studentService.studentOne(student);
		System.out.println(student1.toString());
	}


//	@Test
//	public void selectStudentTest() {
//		Student student = new Student();
//		student.setId(1);
//		List<Student> students = studentService.students(student);
//		System.out.println(student.toString());
//	}



	@Resource(name = "postgresDataSource")
	private DataSource postgresDataSource;
	@Resource(name = "mysqlMasterDataSource")
	private DataSource mysqlMasterDataSource;
	@Resource(name = "mysqlSlaveOneDataSource")
	private DataSource mysqlSlaveOneDataSource;

	@Test
	public void testConnection() throws Exception{
		Connection c1 = postgresDataSource.getConnection("postgres","postgres");
		System.out.println("c1" + c1.getMetaData().getURL());
		Connection c2 = mysqlMasterDataSource.getConnection("root","19950404ljh");
		System.out.println("c2" + c2.getMetaData().getURL());
		Connection c3 = mysqlSlaveOneDataSource.getConnection("root","19950404ljh");
		System.out.println("c3" + c3.getMetaData().getURL());

	}


	@Test
	public void pageHelpTest() {
		Page<Student> page = PageHelper.startPage(1,2,"id desc");
		studentService.selectStudentAll();
		PageInfo<Student> info = new PageInfo<>(page);
		System.out.println("info:" + info);
	}

	@Test
	public void DataTest() {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
//		TemporalQuery<Integer> query =
	}



}
