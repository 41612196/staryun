package edu.snnu.startyun.dao;

import edu.snnu.startyun.entity.Teacher;
import edu.snnu.startyun.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao {

    /*
    通过openID检索老师
     */
    Teacher selectTeacherByOpenId(String openid);

    /*
    通过工号检索老师
     */
    Teacher selectTeacherById(Integer id);

    /*
    老师网页登录
     */
    Teacher teacherWebLogin(@Param("id") Integer id);

    /*
    为老师添加密码用于登录网页端
     */
    void addPassword(@Param("openId") String openId, @Param("password") String password);

    void teacherRegister(@Param("user") User user);
}
