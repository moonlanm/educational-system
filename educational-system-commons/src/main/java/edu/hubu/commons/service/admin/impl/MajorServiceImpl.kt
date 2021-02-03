package edu.hubu.commons.service.admin.impl
import edu.hubu.commons.model.admin.Major
import edu.hubu.commons.repository.admin.MajorRepository
import edu.hubu.commons.service.admin.IMajorService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class MajorServiceImpl(private val repository: MajorRepository) : IMajorService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: Major): Major {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val major = repository.save(t)
            log.debug("保存成功，数据为${major}")
            return major
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
            return if (!byId.majorIsDeleted) {
                byId.majorIsDeleted = true
                val major = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${major}")
                major.majorIsDeleted
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
            val major = repository.delete(byId)
            log.debug("删除成功，数据为${major}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: Major): Major {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val major = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${major}")
            return major
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
            return if (!byId.majorIsDeleted && !byId.majorIsForbidden) {
                byId.majorIsForbidden = true
                val major = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${major}")
                major.majorIsForbidden
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): Major {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val major = byId.get()
                log.debug("查找成功，数据为${major}")
                return major
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<Major> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<Major> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.Major
    ): MutableList<edu.hubu.commons.mybatis.model.Major> {
        return mutableListOf()
    }
}