package edu.hubu.commons.service.student

import edu.hubu.commons.model.student.Score;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IScoreService {
    fun save(t: Score): Score
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Score): Score
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Score
    fun selectAllOrderBy(order: String = "scoreId"): List<Score>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "scoreId"): List<Score>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "scoreId", t: edu.hubu.commons.mybatis.model.Score): List<edu.hubu.commons.mybatis.model.Score>
}
