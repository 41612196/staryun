package edu.snnu.startyun;

import edu.snnu.startyun.dao.StudentDao;
import edu.snnu.startyun.entity.Student;
import edu.snnu.startyun.service.CourseService;
import edu.snnu.startyun.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class StarYunApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    StudentDao studentDao;

    @Autowired
    CourseService courseService;

    @Test
    public void contextLoads() {
        String classmsg = "";
                //request.getParameter("classmsg");
        classmsg = classmsg.replace("{", "");
        classmsg = classmsg.replace("}", "");
        String[] split = classmsg.split(",",2);
        for (String s : split) {

            System.out.println(s);
        }
    }

}
