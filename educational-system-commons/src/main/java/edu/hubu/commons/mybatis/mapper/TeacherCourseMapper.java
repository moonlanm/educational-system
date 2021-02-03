package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.TeacherCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherCourseMapper {
    /**
     * delete by primary key
     * @param teacherCourseId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String teacherCourseId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TeacherCourse record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TeacherCourse record);

    /**
     * select by primary key
     * @param teacherCourseId primary key
     * @return object by primary key
     */
    TeacherCourse selectByPrimaryKey(String teacherCourseId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TeacherCourse record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TeacherCourse record);
}