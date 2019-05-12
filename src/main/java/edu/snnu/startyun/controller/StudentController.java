package edu.snnu.startyun.controller;

import edu.snnu.startyun.entity.Class;

import edu.snnu.startyun.entity.Course;
import edu.snnu.startyun.entity.Student;
import edu.snnu.startyun.entity.Teacher;
import edu.snnu.startyun.service.CourseService;
import edu.snnu.startyun.service.StudentService;
import edu.snnu.startyun.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by pengweijie on 2019/4/22
 */
@RestController
public class StudentController
{
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;


    @RequestMapping(value = "/getStudentCourse")
    public Map<String,Object> getStudentClass(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Student student = (Student) request.getSession().getAttribute("user");
        //Integer studentId = request.getSession().getId();
        List<Class> classList=studentService.getStudentCourse(student.getStudentId());
        modelMap.put("classList", classList);
        return modelMap;
    }

    @RequestMapping(value = "/getClassInfo")
    public Map<String, Object> getClassInfo(@RequestParam("classId") Integer classId, @RequestParam("courseId") Integer courseId, @RequestParam("teacherId") Integer teacherId) {
        Teacher teacher = new Teacher();
        teacher = teacherService.getTeacherMsg(teacherId);

        Course course = courseService.getCourseMsg(courseId);
        course.setTeacher(teacher);

        Class clazz = studentService.getClassInfo(classId);
        clazz.setCourse(course);

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("classinfo", clazz);
        System.out.println("classinfo" + clazz);
        return modelMap;

    }

}
