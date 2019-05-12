package edu.snnu.startyun.service;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.Student;

import java.util.List;
import java.util.Map;

public interface CourseService {

    List<Course> getAllCourseMsg(Integer id);

    void updateCourseName(Integer id, String name);

    Course getCourseMsg(Integer courseId);

    void addCourse(Course course);

    void addClass(Class clazz);

    Map<String, Object> getRandomStudent(String id);

    List<Student> getStudents(String id);

    List<Class> getClassInCourse(Integer id);

    void delClass(Integer courseId, Integer classId);
}
