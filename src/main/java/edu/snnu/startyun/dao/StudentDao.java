package edu.snnu.startyun.dao;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Student;
import edu.snnu.startyun.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    /*
    通过openID检索学生
     */
    Student selectStudentByOpenId(@Param("openId") String openId);

    /*
    用户注册
    @identity为身份信息，即"Teacher"|"Student"
     */
    void studentRegister(@Param("user") User user);

    /*
    通过学号检索学生
     */
    Student selectStudentById(Integer id);

    /*
    通过学号获取学生的所有课程和班级信息
     */
    List<Class> getClassByStudentId(@Param("id") Integer id);


}
