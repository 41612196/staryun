package edu.snnu.startyun.service;

import edu.snnu.startyun.entity.Teacher;

public interface TeacherService {

    void addTeacherTable(Integer id);

    Teacher teacherWebLogin(Integer id, String password);

    void addPassword(String openId, String password);

    Teacher getTeacherMsg(Integer teacherId);
}
