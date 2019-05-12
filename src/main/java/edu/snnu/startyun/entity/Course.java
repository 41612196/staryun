package edu.snnu.startyun.entity;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    //课程标识
    private Integer courseId;
    private String courseName;
    private String courseInfo;
    private boolean isTop;
    private Teacher teacher;
    private Integer teacherId;
    private List<Class> classes;

    public Course(){
        this.isTop = false;
    }

    public Course(Integer courseId, String courseName, Integer teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.isTop = false;
    }

    public Course(Integer courseId, String courseName, String courseInfo, Integer teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.isTop = false;
        this.teacherId = teacherId;
    }

}
