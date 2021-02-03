package edu.hubu.commons.service.teacher

import edu.hubu.commons.model.teacher.TeacherCourse;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface ITeacherCourseService {
    fun save(t: TeacherCourse): TeacherCourse
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: TeacherCourse): TeacherCourse
    fun selectOneById(id: String): TeacherCourse
    fun selectAllOrderBy(order: String = "teacherCourseId"): List<TeacherCourse>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "teacherCourseId"): List<TeacherCourse>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "teacherCourseId", t: edu.hubu.commons.mybatis.model.TeacherCourse): List<edu.hubu.commons.mybatis.model.TeacherCourse>
}
