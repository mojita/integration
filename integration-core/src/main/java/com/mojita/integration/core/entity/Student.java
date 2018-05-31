package com.mojita.integration.core.entity;


/**
 * @author lijunhong
 * @since 18/5/28 上午3:23
 */
public class Student {


    private Integer id;
    private String username;
    private String password;
//    private Package aPackage;
//    private StudentClass studentClass;


    public Student() {}

//    public StudentClass getStudentClass() {
//        return studentClass;
//    }
//
//    public void setStudentClass(StudentClass studentClass) {
//        this.studentClass = studentClass;
//    }
//
//    public Package getaPackage() {
//        return aPackage;
//    }
//
//    public void setaPackage(Package aPackage) {
//        this.aPackage = aPackage;
//    }

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
