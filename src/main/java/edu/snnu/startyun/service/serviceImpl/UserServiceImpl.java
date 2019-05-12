package edu.snnu.startyun.service.serviceImpl;

import edu.snnu.startyun.dao.StudentDao;
import edu.snnu.startyun.dao.TeacherDao;
import edu.snnu.startyun.entity.Student;
import edu.snnu.startyun.entity.Teacher;
import edu.snnu.startyun.entity.User;
import edu.snnu.startyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    /*
    用户登录
     */
    @Override
    public Map<String, Object> userLogin(String openid) {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        int code = 0;
        String identity = null;
        //根据OPenID进行检索
        try{
            user = studentDao.selectStudentByOpenId(openid);
            if (user != null) {
                code = 1;
                identity = "student";
                //加入身份信息
            }else {
                user = teacherDao.selectTeacherByOpenId(openid);
                if (user != null) {
                    code = 1;
                    identity = "teacher";
                }
            }
        }catch (Exception e){
            System.out.println("****************************************异常");
            e.printStackTrace();
        }finally {
            map.put("code",code);
            map.put("identity", identity);
            map.put("user", user);
        }
        return map;
    }

    /*
    用户注册
     */
    @Override
    public void userRegister(User user, String identity) {
        if(identity.equals("student")){
            studentDao.studentRegister(user);
        }else{
            teacherDao.teacherRegister(user);
        }


    }

    /*
    根据ID查找用户
     */
    @Override
    public boolean getUserById(Integer id, String identity) {
        if ("student".equals(identity)) {
            Student student = studentDao.selectStudentById(id);
            return student == null;
        }else if ("teacher".equals(identity)) {
            Teacher teacher = teacherDao.selectTeacherById(id);
            return teacher == null;
        }
        return false;
    }


}
