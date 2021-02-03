package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Role;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IRoleService {
    fun save(t: Role): Role
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Role): Role
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Role
    fun selectAllOrderBy(order: String = "roleId"): List<Role>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "roleId"): List<Role>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "roleId", t: edu.hubu.commons.mybatis.model.Role): List<edu.hubu.commons.mybatis.model.Role>
}
