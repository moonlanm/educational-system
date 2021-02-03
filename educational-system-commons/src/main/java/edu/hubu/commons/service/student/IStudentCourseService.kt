package edu.hubu.commons.service.student

import edu.hubu.commons.model.student.StudentCourse;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IStudentCourseService {
    fun save(t: StudentCourse): StudentCourse
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: StudentCourse): StudentCourse
    fun selectOneById(id: String): StudentCourse
    fun selectAllOrderBy(order: String = "studentCourseId"): List<StudentCourse>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentCourseId"): List<StudentCourse>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentCourseId", t: edu.hubu.commons.mybatis.model.StudentCourse): List<edu.hubu.commons.mybatis.model.StudentCourse>
}
