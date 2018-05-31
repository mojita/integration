package com.mojita.integration.core.entity;

import java.util.List;

/**
 * @author lijunhong
 * @since 18/5/30 下午3:33
 */
public class StudentClass {

    private Integer id;
    private String className;
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
