package edu.hubu.commons.service.teacher.impl
import edu.hubu.commons.model.teacher.Teacher
import edu.hubu.commons.repository.teacher.TeacherRepository
import edu.hubu.commons.service.teacher.ITeacherService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.persistence.criteria.Predicate

@Service
class TeacherServiceImpl(private val repository: TeacherRepository) : ITeacherService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: Teacher): Teacher {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val teacher = repository.save(t)
            log.debug("保存成功，数据为${teacher}")
            return teacher
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
            return if (!byId.teacherIsDeleted) {
                byId.teacherIsDeleted = true
                val teacher = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${teacher}")
                teacher.teacherIsDeleted
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
            val teacher = repository.delete(byId)
            log.debug("删除成功，数据为${teacher}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: Teacher): Teacher {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val teacher = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${teacher}")
            return teacher
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
            return if (!byId.teacherIsDeleted && !byId.teacherIsForbidden) {
                byId.teacherIsForbidden = true
                val teacher = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${teacher}")
                teacher.teacherIsForbidden
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): Teacher {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val teacher = byId.get()
                log.debug("查找成功，数据为${teacher}")
                return teacher
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<Teacher> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<Teacher> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.Teacher
    ): MutableList<edu.hubu.commons.mybatis.model.Teacher> {
        return mutableListOf()
    }
}