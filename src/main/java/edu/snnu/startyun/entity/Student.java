package edu.snnu.startyun.entity;

import lombok.Data;

//@EqualsAndHashCode(callSuper = false)
//@ToString(callSuper = true)
@Data
public class Student extends User{

    private Integer studentId;
    private String studentName;

    private Integer totalGrade;
    private String openId;


    public Student() {
    }

    public Student(Integer studentId, String studentName, Integer score) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.totalGrade = score;
    }
    public Student(Integer studentId, String studentName, String openId) {
        super(studentId, studentName, openId);
        this.studentId = studentId;
        this.studentName = studentName;
        this.openId = openId;
    }

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

}
