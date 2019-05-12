package edu.snnu.startyun.dao;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseDao {

    /*
    创建课程
     */
    void createCourse(Course course);

    /*
    得到教师名下所有课程列表
     */
    List<Course> getAllCourse(Integer teacherId);
    /*
    得到课程下所有班级
     */
    //List<Class> getAllClass(Integer courseId);

    void updateCourseName(@Param("id") Integer id, @Param("newName")String newName);

    Course getOneCourse(Integer courseId);
}
