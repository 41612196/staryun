package edu.snnu.startyun.dao;

import edu.snnu.startyun.entity.ClassFile;
import edu.snnu.startyun.entity.CourseFile;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseFileDao {


    /**
     * @param tableName 上传目标表名
     * @param courseFile 课程文件包装类
     */
    void uploadFile(@Param("tableName") String tableName, @Param("courseFile") CourseFile courseFile);

    /**
     * @param tableName 下载目标表名
     * @param fileId 具体文件ID
     * @return 返回文件包装类
     */
    CourseFile downloadFile(@Param("tableName")String tableName, @Param("fileId") String fileId);

    /**
     * @param targetTable 克隆目标表名，即班级表名
     * @param rootTable 克隆的源表名
     * @param classFile 包装的文件信息
     */
    void assignFile(@Param("targetTable") String targetTable,
                    @Param("rootTable") String rootTable,
                    @Param("classFile") ClassFile classFile);

}
