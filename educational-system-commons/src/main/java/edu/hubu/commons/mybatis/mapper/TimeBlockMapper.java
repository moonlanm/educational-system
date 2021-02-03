package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.TimeBlock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeBlockMapper {
    /**
     * delete by primary key
     * @param timeBlockId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String timeBlockId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(TimeBlock record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TimeBlock record);

    /**
     * select by primary key
     * @param timeBlockId primary key
     * @return object by primary key
     */
    TimeBlock selectByPrimaryKey(String timeBlockId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TimeBlock record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TimeBlock record);
}