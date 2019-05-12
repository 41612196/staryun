package edu.snnu.startyun.controller;

import com.alibaba.fastjson.JSON;
import edu.snnu.startyun.entity.User;
import edu.snnu.startyun.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam("openid") String openid, HttpServletRequest request) {
        Map<String, Object> map = userService.userLogin(openid);
        String identity = (String) map.get("identity");

        String sessionId = request.getSession().getId();
        System.out.println("sessionID"+sessionId);
        User user = (User) map.get("user");
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("identity", identity);
        returnMap.put("sessionId", sessionId);
        returnMap.put("code",map.get("code"));
        request.getSession().setAttribute("user",user);
        return returnMap;
    }

    @PostMapping("/register")
    public String register(@RequestParam("openid")String openid,@RequestParam("name") String name,@RequestParam("id") Integer id,@RequestParam("identity") String identity) {
        User user = new User(id,name,openid);
        String identitystr=(identity.equals("学生")?"student":"teacher");
        System.out.println(identitystr);

        try {
            userService.userRegister(user,identitystr);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }

    @RequestMapping("/check")
    public boolean hasUser(Integer id, String identity) {
        return userService.getUserById(id, identity);
    }

}
