package com.mojita.integration.core.entity;


/**
 * @author lijunhong
 * @since 18/5/28 上午3:23
 */
public class Student {


    private Integer id;
    private String username;
    private String password;
    private ClassEntity classEntity;

    public Student() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", classEntity=" + classEntity +
                '}';
    }
}
