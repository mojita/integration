package com.mojita.integration.core;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mojita.integration.core.entity.ClassEntity;
import com.mojita.integration.core.entity.Student;
import com.mojita.integration.core.service.ClassEntityService;
import com.mojita.integration.core.service.StudentServiceImpl;

/**
 * @author lijunhong
 * @since 18/6/9 下午11:22
 * 进行测试class——student
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassStudentTest {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private ClassEntityService classEntityService;

    //测试封装成list
    @Test
    public void Test1() {
        List<ClassEntity> classEntities = classEntityService.getClassEntitys("%班%");
        System.out.println(classEntities);
    }

    @Test
    public void addClassEntityTest() {
        ClassEntity entity = new ClassEntity();
        entity.setClassName("三班");
        int primaryKey = classEntityService.addClassEntity(entity);
        System.out.println(primaryKey);
    }

    //封装map
    @Test
    public void test2() {
        Map<String,ClassEntity> classEntityMap = classEntityService.seleCLassEntityMap(1);
        System.out.println(classEntityMap);
    }

    //封装多个对象到map
    @Test
    public void test3() {
        Map<Integer,ClassEntity> classEntityMap = classEntityService.seleCLassEntityMaps();
        System.out.println(classEntityMap);
    }

    //通过注解实现
    @Test
    public void test4() {
        Map<Integer,ClassEntity> classEntityMap = classEntityService.aSeleCLassEntityMaps();
        System.out.println(classEntityMap);
    }

    //实现级联查询
    @Test
    public void test5() {
        Student student = studentService.getStudentAndClassById(1);
        System.out.println(student);
    }

    //下面是一对一查询
    @Test
    public void test6() {
        Student student = studentService.getStudentAndClassByIdAccios(1);
        //在懒加载过程中懒加载之后需要手动切换数据源，可以解决报错问题
//        DataBaseContextHolder.setDatabaseType(DataBaseContextHolder.DataBaseType.MYSQLSLAVEONE);
        System.out.println(student.getClassEntity().getClassName());
//        DataBaseContextHolder.clearDataBaseType();
    }

    @Test
    public void test7() {
        Student student = studentService.getSutdentAndClassByIdAnnot(1);
        System.out.println(student);
    }


    //下面是一对多查询
    @Test
    public void test8() {
        ClassEntity classEntity = classEntityService.selectClassEntityXml(1);
        System.out.println(classEntity);
    }

    @Test
    public void test9() {
        ClassEntity classEntity = classEntityService.selectClassEntitySimpleXml(1);
        System.out.println(classEntity);
    }

    @Test
    public void test10() {
        ClassEntity classEntity = classEntityService.selectClassEntityAnnot(2);
        System.out.println(classEntity);
    }






}
