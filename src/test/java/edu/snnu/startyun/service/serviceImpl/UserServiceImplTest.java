package edu.snnu.startyun.service.serviceImpl;

import edu.snnu.startyun.dao.StudentDao;
import edu.snnu.startyun.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Create by pengweijie on 2019/4/21
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
    @Autowired
    StudentDao studentDao;
    @Test
    public void userRegister() throws Exception {
        User user=new User(41612196,"彭卫杰","oSOMf5db0uP4qRUedaUJPvqShh2M");
        String identity = "teacher";
        studentDao.studentRegister(user);
    }

}