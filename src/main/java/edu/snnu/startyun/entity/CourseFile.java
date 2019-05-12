package edu.snnu.startyun.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CourseFile {

    //绑定课程ID
    private Integer courseId;
    //课程文件标识，规定：由文件名+“.”+文件后缀组合
    private String fileId;
    //文件名称
    private String fileName;
    //文件后缀
    private String suffix;
    //文件描述
    private String desc;
    //文件
    private byte[] file;
    //创建时间
    private Date createTime;
    //封装的课程信息
    private Course course;

    public CourseFile() {
    }

    public CourseFile(Integer courseId, String fileId) {
        this.courseId = courseId;
        this.fileId = fileId;
    }

    public CourseFile(Integer courseId, String fileId, String fileName, String suffix, byte[] file) {
        this.courseId = courseId;
        this.fileId = fileId;
        this.fileName = fileName;
        this.suffix = suffix;
        this.file = file;
    }

    public CourseFile(Integer courseId, String fileId, String fileName, String suffix, String desc, byte[] file, Date createTime) {
        this.courseId = courseId;
        this.fileId = fileId;
        this.fileName = fileName;
        this.suffix = suffix;
        this.desc = desc;
        this.file = file;
        this.createTime = createTime;
    }
}
