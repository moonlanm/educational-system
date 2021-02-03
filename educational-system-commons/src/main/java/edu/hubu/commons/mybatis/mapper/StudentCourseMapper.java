package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.StudentCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentCourseMapper {
    /**
     * delete by primary key
     * @param studentCourseId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String studentCourseId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(StudentCourse record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(StudentCourse record);

    /**
     * select by primary key
     * @param studentCourseId primary key
     * @return object by primary key
     */
    StudentCourse selectByPrimaryKey(String studentCourseId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(StudentCourse record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(StudentCourse record);
}