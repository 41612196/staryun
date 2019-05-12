package edu.snnu.startyun.entity;

import lombok.Data;

@Data
public class StudentCourse {

    //学生ID
    private Integer studentId;
    //课程ID
    private Integer courseId;
    //班级ID
    private Integer classId;
    //表标识ID
    private Integer gradeId;
    //平时成绩
    private Integer usualGrade;
    //测试成绩
    private Integer testGrade;
    //总成绩
    private Integer totalGrade;

    private Student student;
    private Course course;
    private Class aClass;

    public StudentCourse() {
    }

    public StudentCourse(Integer studentId, Integer courseId, Integer classId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.classId = classId;
    }

    public StudentCourse(Integer studentId, Integer courseId, Integer classId, Integer gradeId, Integer usualGrade, Integer testGrade, Integer totalGrade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.classId = classId;
        this.gradeId = gradeId;
        this.usualGrade = usualGrade;
        this.testGrade = testGrade;
        this.totalGrade = totalGrade;
    }
}
