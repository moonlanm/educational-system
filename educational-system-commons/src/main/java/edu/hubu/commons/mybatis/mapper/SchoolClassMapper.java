package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.SchoolClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchoolClassMapper {
    /**
     * delete by primary key
     * @param schoolClassId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String schoolClassId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(SchoolClass record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SchoolClass record);

    /**
     * select by primary key
     * @param schoolClassId primary key
     * @return object by primary key
     */
    SchoolClass selectByPrimaryKey(String schoolClassId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SchoolClass record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SchoolClass record);
}