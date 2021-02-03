package edu.hubu.commons.service.student

import edu.hubu.commons.model.student.StudentSelectCourse;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IStudentSelectCourseService {
    fun save(t: StudentSelectCourse): StudentSelectCourse
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: StudentSelectCourse): StudentSelectCourse
    fun selectOneById(id: String): StudentSelectCourse
    fun selectAllOrderBy(order: String = "studentselectCourseId"): List<StudentSelectCourse>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentselectCourseId"): List<StudentSelectCourse>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentselectCourseId", t: edu.hubu.commons.mybatis.model.StudentSelectCourse): List<edu.hubu.commons.mybatis.model.StudentSelectCourse>
}
