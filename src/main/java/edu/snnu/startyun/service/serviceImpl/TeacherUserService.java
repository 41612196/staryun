package edu.snnu.startyun.service.serviceImpl;

import edu.snnu.startyun.dao.TeacherDao;
import edu.snnu.startyun.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherUserService implements UserDetailsService {

    @Autowired
    TeacherDao teacherDao;

    @Override public UserDetails loadUserByUsername(String username) {
        //重写loadUserByUsername 方法获得 userdetails 类型用户
        Teacher user = teacherDao.teacherWebLogin(Integer.valueOf(username));
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        authorities.add(new SimpleGrantedAuthority("teacher"));
        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getTeacherId()), user.getPassword(), authorities
        );
    }
}
