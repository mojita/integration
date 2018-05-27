package com.mojita.integration.core.dao;

import org.apache.ibatis.annotations.Insert;
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
            "INSERT INTO student(id,username,password) VALUES(#{student.id},#{student.username},#{student.password})"
    )
    int insertStudent(@Param("student")Student student);


    @Select({
            "SELECT * FROM student WHERE id=#{id}"
    })
    Student selectStudent(@Param("id")Integer id);

}
