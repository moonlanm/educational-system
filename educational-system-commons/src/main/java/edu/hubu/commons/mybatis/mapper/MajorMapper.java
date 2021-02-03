package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Major;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MajorMapper {
    /**
     * delete by primary key
     * @param majorId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String majorId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Major record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Major record);

    /**
     * select by primary key
     * @param majorId primary key
     * @return object by primary key
     */
    Major selectByPrimaryKey(String majorId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Major record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Major record);
}