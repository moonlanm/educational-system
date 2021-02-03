package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    /**
     * delete by primary key
     * @param adminId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String adminId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Admin record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Admin record);

    /**
     * select by primary key
     * @param adminId primary key
     * @return object by primary key
     */
    Admin selectByPrimaryKey(String adminId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Admin record);

    List<Admin> selectLikePageOrderBy(int offset, int limit, String order, Admin admin);
}