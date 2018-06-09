package com.mojita.integration.core.entity;

import java.util.List;

/**
 * @author lijunhong
 * @since 18/6/9 下午11:06
 */
public class ClassEntity {

    private Integer id;
    private String className;

    private List<Student> student;


    public ClassEntity() {}

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

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", student=" + student +
                '}';
    }
}
