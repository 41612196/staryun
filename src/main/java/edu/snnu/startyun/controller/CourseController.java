package edu.snnu.startyun.controller;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.Student;
import edu.snnu.startyun.entity.Teacher;
import edu.snnu.startyun.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/course")
    public List<Course> getAllCourse(HttpServletRequest request) {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");
        return courseService.getAllCourseMsg(teacher.getTeacherId());
    }

    @GetMapping("/getStudents")
    public List<Student> getAllStudent(String id){
        System.out.println("成员："+courseService.getStudents(id));
        return courseService.getStudents(id);

    }

    @GetMapping("/getRandom")
    public Map<String, Object> getRandomStudent(String id) {
        return courseService.getRandomStudent(id);
    }

    @GetMapping("/delClass")
    public List<Class> getClass(String id) {
        System.out.println(id);
        String[] split = id.split("-");
        courseService.delClass(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
        return courseService.getClassInCourse(Integer.valueOf(split[0]));
    }
}
