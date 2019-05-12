package edu.snnu.startyun.dao;

import edu.snnu.startyun.entity.Class;
import edu.snnu.startyun.entity.StudentCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by pengweijie on 2019/4/22
 */
@Repository
public interface StudentCourseDao {
    /*
    通过学号查询到学生所有的班级
     */
    List<StudentCourse> queryCourseByStudentId(Integer id);
}
