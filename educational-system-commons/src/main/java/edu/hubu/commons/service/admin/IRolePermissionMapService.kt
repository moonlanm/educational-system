package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.RolePermissionMap;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IRolePermissionMapService {
    fun save(t: RolePermissionMap): RolePermissionMap
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: RolePermissionMap): RolePermissionMap
    fun selectOneById(id: String): RolePermissionMap
    fun selectAllOrderBy(order: String = "rolePermissionMapId"): List<RolePermissionMap>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "rolePermissionMapId"): List<RolePermissionMap>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "rolePermissionMapId", t: edu.hubu.commons.mybatis.model.RolePermissionMap): List<edu.hubu.commons.mybatis.model.RolePermissionMap>
}
