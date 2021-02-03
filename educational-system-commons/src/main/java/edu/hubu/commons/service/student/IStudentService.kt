package edu.hubu.commons.service.student

import edu.hubu.commons.model.student.Student;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IStudentService {
    fun save(t: Student): Student
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Student): Student
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Student
    fun selectAllOrderBy(order: String = "studentId"): List<Student>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentId"): List<Student>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentId", t: edu.hubu.commons.mybatis.model.Student): List<edu.hubu.commons.mybatis.model.Student>
}
