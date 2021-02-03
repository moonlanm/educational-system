package edu.hubu.commons.service

import edu.hubu.commons.model.SchoolClass

/**
 * @author moonlan
 * date 2021/1/25 下午2:07
 */
interface ISchoolClassService {
    fun save(t: SchoolClass): SchoolClass
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: SchoolClass): SchoolClass
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): SchoolClass
    fun selectAllOrderBy(order: String = "schoolClassId"): List<SchoolClass>
    fun selectAllPageOrderBy(
        currentPage: Int = 1,
        pageSize: Int = 5,
        order: String = "schoolClassId"
    ): List<SchoolClass>

    fun selectLikePageOrderBy(
        currentPage: Int = 1,
        pageSize: Int = 5,
        order: String = "schoolClassId",
        t: SchoolClass
    ): List<SchoolClass>
}