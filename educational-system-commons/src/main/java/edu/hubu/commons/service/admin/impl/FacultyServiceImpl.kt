package edu.hubu.commons.service.admin.impl
import edu.hubu.commons.model.admin.Faculty
import edu.hubu.commons.repository.admin.FacultyRepository
import edu.hubu.commons.service.admin.IFacultyService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class FacultyServiceImpl(private val repository: FacultyRepository) : IFacultyService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: Faculty): Faculty {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val faculty = repository.save(t)
            log.debug("保存成功，数据为${faculty}")
            return faculty
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
            return if (!byId.facultyIsDeleted) {
                byId.facultyIsDeleted = true
                val faculty = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${faculty}")
                faculty.facultyIsDeleted
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
            val faculty = repository.delete(byId)
            log.debug("删除成功，数据为${faculty}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: Faculty): Faculty {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val faculty = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${faculty}")
            return faculty
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
            return if (!byId.facultyIsDeleted && !byId.facultyIsForbidden) {
                byId.facultyIsForbidden = true
                val faculty = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${faculty}")
                faculty.facultyIsForbidden
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): Faculty {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val faculty = byId.get()
                log.debug("查找成功，数据为${faculty}")
                return faculty
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<Faculty> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<Faculty> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.Faculty
    ): MutableList<edu.hubu.commons.mybatis.model.Faculty> {
        return mutableListOf()
    }
}