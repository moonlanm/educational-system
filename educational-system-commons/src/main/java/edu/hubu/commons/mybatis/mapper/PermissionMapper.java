package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {
    /**
     * delete by primary key
     * @param permissionId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String permissionId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Permission record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Permission record);

    /**
     * select by primary key
     * @param permissionId primary key
     * @return object by primary key
     */
    Permission selectByPrimaryKey(String permissionId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Permission record);
}