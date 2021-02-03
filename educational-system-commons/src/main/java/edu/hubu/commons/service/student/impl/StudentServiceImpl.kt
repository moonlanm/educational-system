package edu.hubu.commons.service.student.impl
import edu.hubu.commons.model.student.Student
import edu.hubu.commons.repository.student.StudentRepository
import edu.hubu.commons.service.student.IStudentService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.persistence.criteria.Predicate

@Service
class StudentServiceImpl(private val repository: StudentRepository) : IStudentService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: Student): Student {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val student = repository.save(t)
            log.debug("保存成功，数据为${student}")
            return student
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
            return if (!byId.studentIsDeleted) {
                byId.studentIsDeleted = true
                val student = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${student}")
                student.studentIsDeleted
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
            val student = repository.delete(byId)
            log.debug("删除成功，数据为${student}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: Student): Student {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val student = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${student}")
            return student
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
            return if (!byId.studentIsDeleted && !byId.studentIsForbidden) {
                byId.studentIsForbidden = true
                val student = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${student}")
                student.studentIsForbidden
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): Student {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val student = byId.get()
                log.debug("查找成功，数据为${student}")
                return student
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<Student> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<Student> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.Student
    ): MutableList<edu.hubu.commons.mybatis.model.Student> {
        return mutableListOf()
    }
}