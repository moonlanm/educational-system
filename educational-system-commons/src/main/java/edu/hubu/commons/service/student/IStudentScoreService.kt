package edu.hubu.commons.service.student

import edu.hubu.commons.model.student.StudentScore;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IStudentScoreService {
    fun save(t: StudentScore): StudentScore
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: StudentScore): StudentScore
    fun selectOneById(id: String): StudentScore
    fun selectAllOrderBy(order: String = "studentscoreId"): List<StudentScore>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentscoreId"): List<StudentScore>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "studentscoreId", t: edu.hubu.commons.mybatis.model.StudentScore): List<edu.hubu.commons.mybatis.model.StudentScore>
}
