package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Faculty;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IFacultyService {
    fun save(t: Faculty): Faculty
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Faculty): Faculty
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Faculty
    fun selectAllOrderBy(order: String = "facultyId"): List<Faculty>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "facultyId"): List<Faculty>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "facultyId", t: edu.hubu.commons.mybatis.model.Faculty): List<edu.hubu.commons.mybatis.model.Faculty>
}
