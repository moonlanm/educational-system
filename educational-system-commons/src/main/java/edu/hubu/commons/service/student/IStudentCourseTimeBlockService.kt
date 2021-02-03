package edu.hubu.commons.service.student

import edu.hubu.commons.model.student.StudentCourseTimeBlock;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IStudentCourseTimeBlockService {
    fun save(t: StudentCourseTimeBlock): StudentCourseTimeBlock
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: StudentCourseTimeBlock): StudentCourseTimeBlock
    fun selectOneById(id: String): StudentCourseTimeBlock
    fun selectAllOrderBy(order: String = "studentCourseTimeBlockId"): List<StudentCourseTimeBlock>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentCourseTimeBlockId"): List<StudentCourseTimeBlock>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentCourseTimeBlockId", t: edu.hubu.commons.mybatis.model.StudentCourseTimeBlock): List<edu.hubu.commons.mybatis.model.StudentCourseTimeBlock>
}
