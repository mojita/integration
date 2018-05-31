package com.mojita.integration.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mojita.integration.core.entity.Student;

/**
 * @author lijunhong
 * @since 18/5/28 上午3:27
 */
@Repository
public interface StudentDao {

    @Insert(
            "INSERT INTO student(username,password) VALUES(#{student.username},#{student.password})"
    )
    @Options(useGeneratedKeys = true,keyColumn = "id")
    int insertStudent(@Param("student")Student student);


    @Select({
            "SELECT * FROM student WHERE id=#{id}"
    })
    Student selectStudent(@Param("id")Integer id);

    @Select({
            "SELECT * FROM student"
    })
    List<Student> selectStudentAll();

    int addStudent(@Param("student")Student student);

    List<Student> select();

}
