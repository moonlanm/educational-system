package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.AnnouncementContent;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IAnnouncementContentService {
    fun save(t: AnnouncementContent): AnnouncementContent
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: AnnouncementContent): AnnouncementContent
    fun selectOneById(id: String): AnnouncementContent
    fun selectAllOrderBy(order: String = "announcementContentId"): List<AnnouncementContent>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "announcementContentId"): List<AnnouncementContent>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "announcementContentId", t: edu.hubu.commons.mybatis.model.AnnouncementContent): List<edu.hubu.commons.mybatis.model.AnnouncementContent>
}
