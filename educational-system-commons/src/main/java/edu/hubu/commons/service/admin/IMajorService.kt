package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Major;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IMajorService {
    fun save(t: Major): Major
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Major): Major
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Major
    fun selectAllOrderBy(order: String = "majorId"): List<Major>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "majorId"): List<Major>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "majorId", t: edu.hubu.commons.mybatis.model.Major): List<edu.hubu.commons.mybatis.model.Major>
}
