package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    /**
     * delete by primary key
     * @param studentId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String studentId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Student record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Student record);

    /**
     * select by primary key
     * @param studentId primary key
     * @return object by primary key
     */
    Student selectByPrimaryKey(String studentId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Student record);
}