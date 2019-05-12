package edu.snnu.startyun.entity;

import lombok.Data;

@Data
public class ClassFile {

    //班级文件ID，应与课程文件ID保持一致
    private String fileId;
    //绑定的相关班级课程信息
    private Integer courseId;
    private Integer classId;
    //班级临时文件，由课程文件拷贝而来
    private byte[] temporaryFile;

    private Class aClass;

    public ClassFile() {
    }

    public ClassFile(String fileId, Integer courseId, Integer classId) {
        this.fileId = fileId;
        this.courseId = courseId;
        this.classId = classId;
    }

    public ClassFile(String fileId, Integer courseId, Integer classId, byte[] temporaryFile) {
        this.fileId = fileId;
        this.courseId = courseId;
        this.classId = classId;
        this.temporaryFile = temporaryFile;
    }
}
