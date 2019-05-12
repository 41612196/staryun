package edu.snnu.startyun.service.serviceImpl;

import edu.snnu.startyun.dao.ClassDao;
import edu.snnu.startyun.dao.CourseDao;
import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.Student;
import edu.snnu.startyun.service.CourseService;
import edu.snnu.startyun.util.RandomPointName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;
    @Autowired
    ClassDao classDao;

    @Override
    public List<Course> getAllCourseMsg(Integer teacherId) {
        return courseDao.getAllCourse(teacherId);
    }

    @Override
    public void updateCourseName(Integer id, String newCourseName) {
        courseDao.updateCourseName(id, newCourseName);
    }

    @Override
    public Course getCourseMsg(Integer courseId) {
        return courseDao.getOneCourse(courseId);
    }

    @Override
    public void addCourse(Course course) {
        courseDao.createCourse(course);
    }

    @Override
    public void addClass(Class clazz){
        classDao.createClass(clazz);
    }

    @Override
    public Map<String, Object> getRandomStudent(String id) {
        String[] split = id.split("-");
        Integer courseId = Integer.valueOf(split[0]);
        Integer classId = Integer.valueOf(split[1]);
        Map<String, Object> map = new HashMap<>();
        List<Student> students = classDao.getAllStudent(courseId, classId);
        Student student = RandomPointName.random(students);

        map.put("studentName",student.getStudentName());
        map.put("studentId",student.getStudentId());

        return map;
    }

    @Override
    public List<Student> getStudents(String id){
        String[] split = id.split("-");
        Integer courseId = Integer.valueOf(split[0]);
        Integer classId = Integer.valueOf(split[1]);
        return classDao.getAllStudent(courseId, classId);
    }

    @Override
    public List<Class> getClassInCourse(Integer id) {
        return classDao.getClassInCourse(id);
    }

    @Override
    public void delClass(Integer courseId, Integer classId) {
        classDao.delClassStudent(courseId, classId);
        classDao.delClass(courseId, classId);
    }
}
