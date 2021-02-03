package edu.hubu.commons.service.admin.impl
import edu.hubu.commons.model.admin.AnnouncementType
import edu.hubu.commons.repository.admin.AnnouncementTypeRepository
import edu.hubu.commons.service.admin.IAnnouncementTypeService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class AnnouncementTypeServiceImpl(private val repository: AnnouncementTypeRepository) : IAnnouncementTypeService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: AnnouncementType): AnnouncementType {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val announcementType = repository.save(t)
            log.debug("保存成功，数据为${announcementType}")
            return announcementType
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun logicalDeleteById(id: String): Boolean {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试逻辑删除ID=${id}的数据")
            val byId = selectOneById(id)
            return if (!byId.announcementTypeIsDeleted) {
                byId.announcementTypeIsDeleted = true
                val announcementType = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${announcementType}")
                announcementType.announcementTypeIsDeleted
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun deleteById(id: String): Boolean {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试删除ID=${id}的数据")
            val byId = selectOneById(id)
            val announcementType = repository.delete(byId)
            log.debug("删除成功，数据为${announcementType}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: AnnouncementType): AnnouncementType {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val announcementType = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${announcementType}")
            return announcementType
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun forbidById(id: String): Boolean {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试封禁ID=${id}的数据")
            val byId = selectOneById(id)
            return if (!byId.announcementTypeIsDeleted && !byId.announcementTypeIsForbidden) {
                byId.announcementTypeIsForbidden = true
                val announcementType = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${announcementType}")
                announcementType.announcementTypeIsForbidden
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): AnnouncementType {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val announcementType = byId.get()
                log.debug("查找成功，数据为${announcementType}")
                return announcementType
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<AnnouncementType> {
        try {
            log.debug("传入Order为${order}")
            val findAll = repository.findAll(Sort.by(Sort.Direction.ASC, order))
            log.debug("取得数据为${findAll}")
            return findAll
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<AnnouncementType> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.AnnouncementType
    ): MutableList<edu.hubu.commons.mybatis.model.AnnouncementType> {
        return mutableListOf()
    }
}