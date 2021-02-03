package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Course;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface ICourseService {
    fun save(t: Course): Course
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Course): Course
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Course
    fun selectAllOrderBy(order: String = "courseId"): List<Course>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "courseId"): List<Course>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "courseId", t: edu.hubu.commons.mybatis.model.Course): List<edu.hubu.commons.mybatis.model.Course>
}
