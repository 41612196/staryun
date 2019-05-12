package edu.snnu.startyun.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CourseExercise {

    //练习题标识ID
    private Integer exerciseId;
    //绑定的知识点的ID
    private String keyPointId;
    //练习类型
    private String kind;
    //练习内容
    private byte[] exercise;
    //练习答案与解析
    private String answer;
    private String analysis;
    //练习创建时间
    private Date createTime;

    private KeyPoint keyPoint;

    public CourseExercise() {
    }

    public CourseExercise(Integer exerciseId, String keyPointId, Date createTime) {
        this.exerciseId = exerciseId;
        this.keyPointId = keyPointId;
        this.createTime = createTime;
    }

    public CourseExercise(Integer exerciseId, String keyPointId, String kind, byte[] exercise, String answer, String analysis, Date createTime) {
        this.exerciseId = exerciseId;
        this.keyPointId = keyPointId;
        this.kind = kind;
        this.exercise = exercise;
        this.answer = answer;
        this.analysis = analysis;
        this.createTime = createTime;
    }
}
