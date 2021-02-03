package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Term;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface ITermService {
    fun save(t: Term): Term
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Term): Term
    fun selectOneById(id: String): Term
    fun selectAllOrderBy(order: String = "termId"): List<Term>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "termId"): List<Term>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "termId", t: edu.hubu.commons.mybatis.model.Term): List<edu.hubu.commons.mybatis.model.Term>
}
