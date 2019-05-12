package edu.snnu.startyun.entity;

import lombok.Data;

import java.util.Date;

/**
 * 本类为课后作业封装类
 */
@Data
public class Homework {

    //作业的课程信息
    private Integer courseId;
    //分配给哪个班级的作业
    private Integer classId;
    //作业标识
    private Integer workId;
    //创建时间
    private Date createTime;
    //作业提交时间
    private Date submitTime;

    private Course course;
    private Class aClass;

    public Homework() {
    }

    public Homework(Integer courseId, Integer classId, Integer workId) {
        this.courseId = courseId;
        this.classId = classId;
        this.workId = workId;
    }

    public Homework(Integer courseId, Integer classId, Integer workId, Date createTime, Date submitTime) {
        this.courseId = courseId;
        this.classId = classId;
        this.workId = workId;
        this.createTime = createTime;
        this.submitTime = submitTime;
    }
}
