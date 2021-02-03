package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Admin;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IAdminService {
    fun save(t: Admin): Admin
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Admin): Admin
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Admin
    fun selectAllOrderBy(order: String = "adminId"): List<Admin>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "adminId"): List<Admin>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "adminId", t: edu.hubu.commons.mybatis.model.Admin): List<edu.hubu.commons.mybatis.model.Admin>
}
