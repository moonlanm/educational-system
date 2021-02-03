package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.StudentSelectCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentSelectCourseMapper {
    /**
     * delete by primary key
     * @param studentSelectCourseId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String studentSelectCourseId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(StudentSelectCourse record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(StudentSelectCourse record);

    /**
     * select by primary key
     * @param studentSelectCourseId primary key
     * @return object by primary key
     */
    StudentSelectCourse selectByPrimaryKey(String studentSelectCourseId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(StudentSelectCourse record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(StudentSelectCourse record);
}