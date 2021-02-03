package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.TeacherSelectCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherSelectCourseMapper {
    /**
     * delete by primary key
     * @param teacherSelectCourseId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String teacherSelectCourseId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TeacherSelectCourse record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TeacherSelectCourse record);

    /**
     * select by primary key
     * @param teacherSelectCourseId primary key
     * @return object by primary key
     */
    TeacherSelectCourse selectByPrimaryKey(String teacherSelectCourseId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TeacherSelectCourse record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TeacherSelectCourse record);
}