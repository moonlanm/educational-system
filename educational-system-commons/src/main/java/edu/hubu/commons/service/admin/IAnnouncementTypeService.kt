package edu.hubu.commons.service.admin

import edu.hubu.commons.model.admin.AnnouncementType;

/**
* @author moonlan
* date 2021/1/25 下午2:07
*/
interface IAnnouncementTypeService {
    fun save(t: AnnouncementType): AnnouncementType
    fun logicalDeleteById(id: String): Boolean
    fun deleteById(id: String): Boolean
    fun updateById(id: String, t: AnnouncementType): AnnouncementType
    fun forbidById(id: String): Boolean
    fun selectOneById(id: String): AnnouncementType
    fun selectAllOrderBy(order: String = "announcementTypeId"): List<AnnouncementType>
    fun selectAllPageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "announcementTypeId"): List<AnnouncementType>
    fun selectLikePageOrderBy(currentPage: Int = 1, pageSize: Int = 5, order: String = "announcementTypeId", t: edu.hubu.commons.mybatis.model.AnnouncementType): List<edu.hubu.commons.mybatis.model.AnnouncementType>
}
