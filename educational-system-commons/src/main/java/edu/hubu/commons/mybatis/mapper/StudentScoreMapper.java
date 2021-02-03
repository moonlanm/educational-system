package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.StudentScore;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentScoreMapper {
    /**
     * delete by primary key
     * @param studentScoreId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String studentScoreId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(StudentScore record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(StudentScore record);

    /**
     * select by primary key
     * @param studentScoreId primary key
     * @return object by primary key
     */
    StudentScore selectByPrimaryKey(String studentScoreId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(StudentScore record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(StudentScore record);
}