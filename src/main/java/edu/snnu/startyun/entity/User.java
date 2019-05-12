package edu.snnu.startyun.entity;

import lombok.Data;

/**
 * 小程序用户的父类，Student和Teacher继承本类
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String openId;
    private String identity;

    public User() {
    }

    public User(Integer id, String name, String openId) {
        this.id = id;
        this.name = name;
        this.openId = openId;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
