package edu.snnu.startyun.util;

import edu.snnu.startyun.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPointName {

    /**
     * @param students 参数为全体学生集合
     * @return 返回选中学生实体
     */
    public static Student random(List<Student> students){

        List<Student> newList = new ArrayList<>();
        while(students.size()>0) {
            int index = new Random().nextInt(students.size());
            newList.add(students.get(index));
            students.remove(index);
        }

        return newList.get(new Random().nextInt(newList.size()));
    }
}
