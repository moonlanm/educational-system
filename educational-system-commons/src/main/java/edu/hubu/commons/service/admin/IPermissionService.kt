package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Permission;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IPermissionService {
    fun save(t: Permission): Permission
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Permission): Permission
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Permission
    fun selectAllOrderBy(order: String = "permissionId"): List<Permission>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "permissionId"): List<Permission>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "permissionId", t: edu.hubu.commons.mybatis.model.Permission): List<edu.hubu.commons.mybatis.model.Permission>
}
