package edu.hubu.commons.service.admin.impl
import edu.hubu.commons.model.admin.RolePermissionMap
import edu.hubu.commons.repository.admin.RolePermissionMapRepository
import edu.hubu.commons.service.admin.IRolePermissionMapService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class RolePermissionMapServiceImpl(private val repository: RolePermissionMapRepository) : IRolePermissionMapService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: RolePermissionMap): RolePermissionMap {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val rolePermissionMap = repository.save(t)
            log.debug("保存成功，数据为${rolePermissionMap}")
            return rolePermissionMap
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
            val rolePermissionMap = repository.delete(byId)
            log.debug("删除成功，数据为${rolePermissionMap}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: RolePermissionMap): RolePermissionMap {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val rolePermissionMap = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${rolePermissionMap}")
            return rolePermissionMap
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): RolePermissionMap {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val rolePermissionMap = byId.get()
                log.debug("查找成功，数据为${rolePermissionMap}")
                return rolePermissionMap
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<RolePermissionMap> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<RolePermissionMap> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.RolePermissionMap
    ): MutableList<edu.hubu.commons.mybatis.model.RolePermissionMap> {
        return mutableListOf()
    }
}