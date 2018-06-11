package com.mojita.integration.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mojita.integration.core.dao.StudentDao;
import com.mojita.integration.core.config.datasource.DataBaseContextHolder;
import com.mojita.integration.core.config.datasource.annotations.DataSourceConnection;
import com.mojita.integration.core.entity.Student;

/**
 * @author lijunhong
 * @since 18/5/28 上午3:33
 */
@Service
public class StudentServiceImpl {

    @Autowired
    private StudentDao studentDao;




    public int addStudentMysql(Student student) {
        int count = studentDao.insertStudent(student);
        return count;
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.POSTGRES)
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student selectStudentMysql(Integer id) {
        return studentDao.selectStudent(id);
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.MYSQLMASTER)
    public Student selectStudentPostgres(Integer id) {
        return studentDao.selectStudent(id);
    }

    @DataSourceConnection(value = DataBaseContextHolder.DataBaseType.POSTGRES)
    public List<Student> selectStudentAll() {
        Page<Student> pageInfo = PageHelper.startPage(1,1);
        studentDao.selectStudentAll();
        PageInfo<Student> info = new PageInfo<>(pageInfo);
        return info.getList();
    }

    public Student studentOne(Student student) {
        return studentDao.selectOne(student);
    }

    @DataSourceConnection(DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public Student getStudentAndClassById(Integer id) {
        return studentDao.selectStudentAndClass(id);
    }

    @DataSourceConnection(DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public Student getStudentAndClassByIdAccios(Integer id) {
        return studentDao.selectStudentAndClassByAssoci(id);
    }

    @DataSourceConnection(DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public Student getSutdentAndClassByIdAnnot(Integer id) {
        return studentDao.selectStudentAndClassByIdOnAnnot(id);
    }


    @DataSourceConnection(DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE)
    public List<Student> getStudentByDataBase() {
        return studentDao.selectStudentByDataBase();
    }


}
