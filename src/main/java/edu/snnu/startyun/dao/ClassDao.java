package edu.snnu.startyun.dao;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {

    /*
    创建班级
     */
    void createClass(Class clazz);

    /*
    得到所有班级，传入课程ID
     */
    List<Class> getAllClass(Integer courseId);

    /*
    得到课程下所有学生信息
     */
    List<Student> getAllStudent(@Param("courseId") Integer courseId, @Param("classId") Integer classId);



    void delClassStudent(@Param("courseId") Integer courseId, @Param("classId") Integer classId);

    void delClass(@Param("courseId") Integer courseId, @Param("classId") Integer classId);

    Class getClassByClassId(Integer classId);

    List<Class> getClassInCourse(Integer id);


}
