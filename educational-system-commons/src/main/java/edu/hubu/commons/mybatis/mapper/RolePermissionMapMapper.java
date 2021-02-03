package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.RolePermissionMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapMapper {
    /**
     * delete by primary key
     * @param rolePermissionId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String rolePermissionId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(RolePermissionMap record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(RolePermissionMap record);

    /**
     * select by primary key
     * @param rolePermissionId primary key
     * @return object by primary key
     */
    RolePermissionMap selectByPrimaryKey(String rolePermissionId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(RolePermissionMap record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(RolePermissionMap record);
}