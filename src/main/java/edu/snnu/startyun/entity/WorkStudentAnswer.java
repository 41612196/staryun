package edu.snnu.startyun.entity;

import lombok.Data;

/**
 * 学生作业信息封装
 */
@Data
public class WorkStudentAnswer {

    //学生ID
    private Integer studentId;
    //课程ID
    private Integer courseId;
    //作业ID
    private Integer workId;
    //练习ID
    private Integer exerciseId;
    //答案
    private String answer;

    private Student student;
    private Course course;
    private Homework work;
    private CourseExercise exercise;

    public WorkStudentAnswer() {
    }

    public WorkStudentAnswer(Integer studentId, Integer courseId, Integer workId, Integer exerciseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.workId = workId;
        this.exerciseId = exerciseId;
    }

    public WorkStudentAnswer(Integer studentId, Integer courseId, Integer workId, Integer exerciseId, String answer) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.workId = workId;
        this.exerciseId = exerciseId;
        this.answer = answer;
    }
}
