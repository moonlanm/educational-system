package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    /**
     * delete by primary key
     * @param teacherId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String teacherId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Teacher record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Teacher record);

    /**
     * select by primary key
     * @param teacherId primary key
     * @return object by primary key
     */
    Teacher selectByPrimaryKey(String teacherId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Teacher record);
}