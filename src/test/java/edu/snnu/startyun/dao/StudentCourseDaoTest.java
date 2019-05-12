package edu.snnu.startyun.dao;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.StudentCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by pengweijie on 2019/4/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentCourseDaoTest {
    @Autowired
    StudentCourseDao studentCourseDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    ClassDao classDao;

    @Test
    public void queryCourseByStudentId() throws Exception {

        List<StudentCourse> studentCourseList;
        studentCourseList = studentCourseDao.queryCourseByStudentId(41612196);

        Integer classId;
        Integer courseId;
        String className;
        Course course;
        Class clazz = new Class();
        List<Class> classList = new ArrayList<>();
        for (StudentCourse studentCourse : studentCourseList) {
            classId = studentCourse.getClassId();
            clazz = classDao.getClassByClassId(classId);
            courseId = studentCourse.getCourseId();
            //获得班级名称
            className = classDao.getClassByClassId(classId).getClassName();
            //获得课程信息
            course = courseDao.getOneCourse(courseId);

            clazz.setCourse(course);
            classList.add(clazz);

        }
        System.out.println(classList);


    }

}