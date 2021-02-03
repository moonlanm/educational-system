package edu.hubu.commons.service.teacher.impl
import edu.hubu.commons.model.teacher.TeacherCourse
import edu.hubu.commons.repository.teacher.TeacherCourseRepository
import edu.hubu.commons.service.teacher.ITeacherCourseService
import edu.hubu.commons.util.ObjectUtils
import edu.hubu.commons.exception.InformationNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class TeacherCourseServiceImpl(private val repository: TeacherCourseRepository) : ITeacherCourseService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: TeacherCourse): TeacherCourse {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val teacherCourse = repository.save(t)
            log.debug("保存成功，数据为${teacherCourse}")
            return teacherCourse
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
            val teacherCourse = repository.delete(byId)
            log.debug("删除成功，数据为${teacherCourse}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: TeacherCourse): TeacherCourse {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val teacherCourse = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${teacherCourse}")
            return teacherCourse
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }
    override fun selectOneById(id: String): TeacherCourse {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val teacherCourse = byId.get()
                log.debug("查找成功，数据为${teacherCourse}")
                return teacherCourse
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<TeacherCourse> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): MutableList<TeacherCourse> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: edu.hubu.commons.mybatis.model.TeacherCourse
    ): MutableList<edu.hubu.commons.mybatis.model.TeacherCourse> {
        return mutableListOf()
    }
}