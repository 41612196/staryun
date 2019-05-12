package edu.snnu.startyun.entity;

import lombok.Data;

/**
 * 作业练习关系表，作业表中存放练习ID，由本表进行查找
 */
@Data
public class WorkExercise {

    //作业ID
    private Integer workId;
    //练习ID
    private Integer exerciseId;

    private Homework work;
    private CourseExercise exercise;

    public WorkExercise() {
    }

    public WorkExercise(Integer workId, Integer exerciseId) {
        this.workId = workId;
        this.exerciseId = exerciseId;
    }
}
