package edu.snnu.startyun.service.serviceImpl;

import edu.snnu.startyun.dao.ClassDao;
import edu.snnu.startyun.dao.CourseDao;
import edu.snnu.startyun.dao.StudentCourseDao;
import edu.snnu.startyun.dao.StudentDao;
import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.StudentCourse;
import edu.snnu.startyun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by pengweijie on 2019/4/22
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    StudentCourseDao studentCourseDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    ClassDao classDao;
    @Override
    public List<Class> getStudentCourse(Integer id) {
        List<StudentCourse> studentCourseList;
        studentCourseList = studentCourseDao.queryCourseByStudentId(id);

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

        return classList;

    }

    @Override
    public Class getClassInfo(Integer classId) {
       return classDao.getClassByClassId(classId);
    }



}
