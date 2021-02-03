package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Term;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TermMapper {
    /**
     * delete by primary key
     * @param termId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String termId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Term record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Term record);

    /**
     * select by primary key
     * @param termId primary key
     * @return object by primary key
     */
    Term selectByPrimaryKey(String termId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Term record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Term record);
}