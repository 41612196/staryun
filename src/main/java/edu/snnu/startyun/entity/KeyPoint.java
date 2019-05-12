package edu.snnu.startyun.entity;

import lombok.Data;

@Data
public class KeyPoint {

    //知识点ID
    private String keyPointId;
    //知识点绑定课程ID
    private Integer courseId;
    //知识点名称
    private String keyPointName;

    private Course course;

    public KeyPoint() {
    }

    public KeyPoint(String keyPointId, Integer courseId) {
        this.keyPointId = keyPointId;
        this.courseId = courseId;
    }

    public KeyPoint(String keyPointId, Integer courseId, String keyPointName) {
        this.keyPointId = keyPointId;
        this.courseId = courseId;
        this.keyPointName = keyPointName;
    }
}
