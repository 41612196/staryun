package edu.snnu.startyun.entity;

import lombok.Data;

@Data
public class WorkStudentGrade {

    //作业ID
    private Integer workId;
    //学生ID
    private Integer studentId;
    //成绩
    private Integer grade;
    private Homework work;
    private Student student;

    public WorkStudentGrade() {
    }

    public WorkStudentGrade(Integer workId, Integer studentId) {
        this.workId = workId;
        this.studentId = studentId;
    }

    public WorkStudentGrade(Integer workId, Integer studentId, Integer grade) {
        this.workId = workId;
        this.studentId = studentId;
        this.grade = grade;
    }
}
