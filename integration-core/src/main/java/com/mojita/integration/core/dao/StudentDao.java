package com.mojita.integration.core.dao;

import java.util.List;
import java.util.Map;

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



    Student selectStudentAndClass(@Param("id")Integer id);

    Student selectStudentAndClassByAssoci(@Param("id")Integer id);

    //这里通过注解实现一对一查询
    @Select({
            "SELECT * FROM student WHERE id=#{id}"
    })
    @Results({
            @Result(column = "class_id",
                    property = "classEntity",
                    one = @One(select = "com.mojita.integration.core.dao.ClassEntityDao.selectClassEntityById")
            )
    })
    Student selectStudentAndClassByIdOnAnnot(@Param("id")Integer id);

    @Select({
            "SELECT * FROM student WHERE class_id=#{classId}"
    })
    List<Student> selectStudentByClassId(Map<String,Object> param);

    //下面进行测试多数据库直接查询不同表的测试方法
    List<Student> selectStudentByDataBase();
//    List<Student> selectStudentByClassId(@Param("classId")Integer classId);

}
