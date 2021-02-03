package edu.hubu.commons.service.teacher

import edu.hubu.commons.model.teacher.TeacherSelectCourse;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface ITeacherSelectCourseService {
    fun save(t: TeacherSelectCourse): TeacherSelectCourse
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: TeacherSelectCourse): TeacherSelectCourse
    fun selectOneById(id: String): TeacherSelectCourse
    fun selectAllOrderBy(order: String = "teacherSelectCourseId"): List<TeacherSelectCourse>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "teacherSelectCourseId"): List<TeacherSelectCourse>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "teacherSelectCourseId", t: edu.hubu.commons.mybatis.model.TeacherSelectCourse): List<edu.hubu.commons.mybatis.model.TeacherSelectCourse>
}
