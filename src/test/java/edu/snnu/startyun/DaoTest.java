package edu.snnu.startyun;

import edu.snnu.startyun.dao.*;
import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.ClassFile;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.CourseFile;
import edu.snnu.startyun.entity.Student;
import edu.snnu.startyun.service.CourseService;
import edu.snnu.startyun.service.TeacherService;
import edu.snnu.startyun.util.ReadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DaoTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    TeacherService service;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    ClassDao classDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseFileDao courseFileDao;

    @Autowired
    CourseService courseService;

    @Test
    public void test() throws SQLException {
        //courseFileDao.uploadFile("course_file_111",
                //new CourseFile(123,"bcd","41612207李文浩","mp",ReadFileUtils.getIns("C:\\Users\\10849\\Desktop\\41612207李文浩.mp")));

        CourseFile courseFile = courseFileDao.downloadFile("course_file_111", "abc");
        String path = "D:\\" + courseFile.getFileName() + "." + courseFile.getSuffix();
        FileOutputStream outs = ReadFileUtils.getOuts(path);
        InputStream ins = ReadFileUtils.bytesToInputStream(courseFile.getFile());
        ReadFileUtils.readBinaryFile(ins, outs);

//        String url = "C:\\Users\\10849\\Desktop\\41612207李文浩.mp";
//        FileInputStream in = ReadFileUtils.getIns(url);
        //Connection connection = dataSource.getConnection();
//        String sql = "insert into course_file_111" +
//                "(course_id,file_id,file,file_name,file_suffix) values" +
//                "(123,'abc',?,'41612207李文浩','mp')";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setBinaryStream(1, in);
//        preparedStatement.execute();

//        String url = "D:\\a.mp";
//        FileOutputStream outs = ReadFileUtils.getOuts(url);
//        String sql = "select file from course_file_111 where file_id='abc'";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()) {
//            InputStream ins = resultSet.getBinaryStream("file");
//            ReadFileUtils.readBinaryFile(ins, outs);
//        }
    }

    @Test
    public void test2() {
        String id = "123456-1125";
        courseService.delClass(123456,1125);
    }



}
