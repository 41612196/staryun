package edu.snnu.startyun.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
public class Teacher extends User {

    private Integer teacherId;
    private String teacherName;
    //用户唯一标识
    private String openId;
    //web端登录所需密码
    private String password;

    public Teacher() {
    }

    public Teacher(Integer teacherId, String teacherName, String openId, String password) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.openId = openId;
        this.password = password;
    }

    public Teacher(Integer teacherId, String teacherName) {
        super(teacherId, teacherName);
    }


}
