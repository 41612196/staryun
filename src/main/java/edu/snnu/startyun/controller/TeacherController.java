package edu.snnu.startyun.controller;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.Teacher;
import edu.snnu.startyun.service.CourseService;
import edu.snnu.startyun.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    CourseService courseService;

    @GetMapping("/updateCourseName")
    public Course updateCourseName(String courseName, Integer courseId) {
        courseService.updateCourseName(courseId, courseName);
        return courseService.getCourseMsg(courseId);
    }

    @PostMapping("/addCourse")
    public void createCourse(Course course){
        Integer randomId = Random.getRandomInteger(6);
        course.setCourseId(randomId);
        courseService.addCourse(course);
    }

    @GetMapping("/addClass")
    public List<Class> createClass(Class clazz){
        Integer randomId = Random.getRandomInteger(4);
        clazz.setClassId(randomId);
        courseService.addClass(clazz);
        return courseService.getClassInCourse(clazz.getCourseId());
    }

}
