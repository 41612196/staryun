package edu.snnu.startyun.controller;

import edu.snnu.startyun.entity.Msg;
import edu.snnu.startyun.entity.Teacher;
import edu.snnu.startyun.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TeacherWeb {

    @Autowired
    TeacherService teacherService;
    
    @PostMapping("/web/login")
    public Msg login(Teacher teacher, HttpServletRequest request) {
        Teacher teacherMsg = teacherService.teacherWebLogin(teacher.getTeacherId(), teacher.getPassword());
        request.getSession().setAttribute("teacher", teacherMsg);
        return Msg.success();
    }

    @PostMapping("/success")
    public String success() {
        System.out.println("success");
        return "success";
    }
}
