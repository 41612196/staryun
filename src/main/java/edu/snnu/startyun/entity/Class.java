package edu.snnu.startyun.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Class {

    //班级ID
    private Integer classId;
    private String className;
    private String classRoom;
    private String classTime;
    private String classWeek;
    private String classDay;
    //班级所绑定的课程ID
    private Integer courseId;
    //封装课程信息
    private Course course;

    public Class() {
    }

    public Class(Integer classId, String courseName, Integer courseId) {
        this.classId = classId;
        this.className = courseName;
        this.courseId = courseId;
    }

    public Class(Integer classId, String className, String classRoom, String classTime, String classWeek, String classDay, Integer courseId) {
        this.classId = classId;
        this.className = className;
        this.classRoom = classRoom;
        this.classTime = classTime;
        this.classWeek = classWeek;
        this.classDay = classDay;
        this.courseId = courseId;
    }

}
