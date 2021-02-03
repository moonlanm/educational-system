package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.StudentCourseTimeBlock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentCourseTimeBlockMapper {
    /**
     * delete by primary key
     * @param studentCourseTimeBlockId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String studentCourseTimeBlockId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(StudentCourseTimeBlock record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(StudentCourseTimeBlock record);

    /**
     * select by primary key
     * @param studentCourseTimeBlockId primary key
     * @return object by primary key
     */
    StudentCourseTimeBlock selectByPrimaryKey(String studentCourseTimeBlockId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(StudentCourseTimeBlock record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(StudentCourseTimeBlock record);
}