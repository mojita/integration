package com.mojita.integration.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.mojita.integration.core.common.basedao.BaseMapper;
import com.mojita.integration.core.entity.Student;

/**
 * @author lijunhong
 * @since 18/5/28 上午3:27
 */
@Repository
public interface StudentDao extends BaseMapper<Student> {

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

}
