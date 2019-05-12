package edu.snnu.startyun.Exception;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(String s) {
        super("用户不存在");
    }
}
