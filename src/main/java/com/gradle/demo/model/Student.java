package com.gradle.demo.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="studentID",unique = true)
    private String studentID;

    @Column(name="fullName")
    private String fullName;

    @Column(name="department")
    private String department;

    @Column(name="block")
    private int block;

    @Column(name="dorm")
    private int dorm;



    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getDorm() {
        return dorm;
    }

    public void setDorm(int dorm) {
        this.dorm = dorm;
    }
}
