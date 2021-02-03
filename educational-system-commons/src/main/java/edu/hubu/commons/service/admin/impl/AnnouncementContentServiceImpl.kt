package edu.hubu.commons.service.admin.impl
import edu.hubu.commons.model.admin.AnnouncementContent
import edu.hubu.commons.repository.admin.AnnouncementContentRepository
import edu.hubu.commons.service.admin.IAnnouncementContentService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class AnnouncementContentServiceImpl(private val repository: AnnouncementContentRepository) : IAnnouncementContentService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: AnnouncementContent): AnnouncementContent {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val announcementContent = repository.save(t)
            log.debug("保存成功，数据为${announcementContent}")
            return announcementContent
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
            val announcementContent = repository.delete(byId)
            log.debug("删除成功，数据为${announcementContent}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: AnnouncementContent): AnnouncementContent {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val announcementContent = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${announcementContent}")
            return announcementContent
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): AnnouncementContent {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val announcementContent = byId.get()
                log.debug("查找成功，数据为${announcementContent}")
                return announcementContent
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<AnnouncementContent> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<AnnouncementContent> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.AnnouncementContent
    ): MutableList<edu.hubu.commons.mybatis.model.AnnouncementContent> {
        return mutableListOf()
    }
}