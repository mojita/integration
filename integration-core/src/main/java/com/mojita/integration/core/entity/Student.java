package com.mojita.integration.core.entity;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author lijunhong
 * @since 18/5/28 上午3:23
 */
public class Student {



    private Integer id;
    @NotNull(message = "参数部门为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
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
