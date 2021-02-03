package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.Announcement;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IAnnouncementService {
    fun save(t: Announcement): Announcement
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: Announcement): Announcement
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): Announcement
    fun selectAllOrderBy(order: String = "announcementId"): List<Announcement>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "announcementId"): List<Announcement>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "announcementId", t: edu.hubu.commons.mybatis.model.Announcement): List<edu.hubu.commons.mybatis.model.Announcement>
}
