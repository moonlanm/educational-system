package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Score;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreMapper {
    /**
     * delete by primary key
     * @param scoreId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String scoreId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Score record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Score record);

    /**
     * select by primary key
     * @param scoreId primary key
     * @return object by primary key
     */
    Score selectByPrimaryKey(String scoreId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Score record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Score record);
}