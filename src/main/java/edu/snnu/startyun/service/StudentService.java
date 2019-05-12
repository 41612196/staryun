package edu.snnu.startyun.service;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.StudentCourse;

import java.util.List;


/**
 * Create by pengweijie on 2019/4/22
 */

public interface StudentService {
    List<Class> getStudentCourse(Integer id);//根据学号获取该学生的所有课程

    Class getClassInfo(Integer classId);//根据班级号获取班级信息


}
