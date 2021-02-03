package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.TimeBlock;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface ITimeBlockService {
    fun save(t: TimeBlock): TimeBlock
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: TimeBlock): TimeBlock
    fun selectOneById(id: String): TimeBlock
    fun selectAllOrderBy(order: String = "timeBlockId"): List<TimeBlock>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "timeBlockId"): List<TimeBlock>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "timeBlockId", t: edu.hubu.commons.mybatis.model.TimeBlock): List<edu.hubu.commons.mybatis.model.TimeBlock>
}
