package com.mojita.integration.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mojita.integration.core.dao.StudentDao;
import com.mojita.integration.core.datasource.annotations.PostgresConnection;
import com.mojita.integration.core.datasource.annotations.ReadOnlyConnection;
import com.mojita.integration.core.datasource.annotations.ReadOrWriteConnection;
import com.mojita.integration.core.entity.Student;

/**
 * @author lijunhong
 * @since 18/5/28 上午3:33
 */
@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDao studentDao;


    //测试postgres数据源
//    @PostgresConnection
//    public int addStudent(Student student) {
//        int count = studentDao.insertStudent(student);
//        return count;
//    }

    @ReadOrWriteConnection
    public int addStudentMysql(Student student) {
        int count = studentDao.insertStudent(student);
        return count;
    }

    @ReadOnlyConnection
    public Student selectStudentMysql(Integer id) {
        return studentDao.selectStudent(id);
    }

    @PostgresConnection
    public Student selectStudentPostgres(Integer id) {
        return studentDao.selectStudent(id);
    }




}
