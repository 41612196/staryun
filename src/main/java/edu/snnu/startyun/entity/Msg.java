package edu.snnu.startyun.entity;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    //    自定义状态码
    private Integer code;

    //    自定义返回信息
    private String msg;

    //    封装
    private Map<String, Object> map = new HashMap<>();

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("处理成功！");
        return msg;
    }

    public static Msg fail(){
        Msg msg = new Msg();
        msg.setCode(400);
        msg.setMsg("处理失败！");
        return msg;
    }

    public Msg add(String key, Object val) {
        this.getMap().put(key, val);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

}
