package edu.snnu.startyun.service.serviceImpl;

import edu.snnu.startyun.dao.TeacherDao;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.Teacher;
import edu.snnu.startyun.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static edu.snnu.startyun.util.IOUtil.getStreamString;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    DataSource dataSource;

    @Autowired
    TeacherDao teacherDao;

    /*
    在老师注册时为老师自动创建一系列表，不与其他老师共享
     */
    @Override
    public void addTeacherTable(Integer id) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("连接信息错误。。。" + e.getMessage());
        }

        String url = "sql/create.sql";
        InputStream in = null;
        try {
            /*
             读取classpath下的sql文件
             */
            in = Resources.getResourceAsStream(url);
        } catch (IOException e) {
            log.error("配置文件信息读取失败。。。" + e.getMessage());
        }
        /*
        将读取的字符流转换成字符串
         */
        String sql = getStreamString(in);
        assert sql != null;
        String[] split = sql.split(";");
        /*
        创建表名称集合，与工号共同形成表名
         */
        String[] suffix = {"class_file_","key_point_","course_exercise_","course_file_","homework_","work_exercise_","work_student_answer_","work_student_grade_"};
        for (int i = 0 ; i < split.length ; i ++) {
            String tableName = suffix[i] + id;
            /*
            代替表中的特殊字符
             */
            split[i] = split[i].replace("$", "homework_" + id);
            split[i] = split[i].replace("@", "key_point_" + id);
            String sqlNew = split[i].replace("?", tableName);

            PreparedStatement preparedStatement = null;
            try {
                assert connection != null;
                preparedStatement = connection.prepareStatement(sqlNew);
                preparedStatement.execute();
            } catch (SQLException e) {
                log.error("创建表失败。。。" + e.getMessage());
            }

        }
    }

    /*
    老师网页端使用工号、密码登录
     */
    @Override
    public Teacher teacherWebLogin(Integer id, String password) {
        return teacherDao.teacherWebLogin(id);
    }

    /*
    修改密码
     */
    @Override
    public void addPassword(String openId, String password) {
        teacherDao.addPassword(openId, password);
    }

    @Override
    public Teacher getTeacherMsg(Integer teacherId) {
        return teacherDao.selectTeacherById(teacherId);
    }
}
