package edu.hubu.commons.service.teacher

import edu.hubu.commons.model.teacher.Teacher;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface ITeacherService {
    fun save(t: Teacher): Teacher
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Teacher): Teacher
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Teacher
    fun selectAllOrderBy(order: String = "teacherId"): List<Teacher>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "teacherId"): List<Teacher>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "teacherId", t: edu.hubu.commons.mybatis.model.Teacher): List<edu.hubu.commons.mybatis.model.Teacher>
}
