package edu.hubu.commons.service.impl

import edu.hubu.commons.exception.InformationNotFoundException
import edu.hubu.commons.model.SchoolClass
import edu.hubu.commons.repository.SchoolClassRepository
import edu.hubu.commons.service.ISchoolClassService
import edu.hubu.commons.util.ObjectUtils
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.persistence.criteria.Predicate

@Service
class SchoolClassServiceImpl(private val repository: SchoolClassRepository) : ISchoolClassService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(t: SchoolClass): SchoolClass {
        log.debug("传入数据为${t}")
        try {
            log.debug("尝试保存数据${t}")
            val schoolClass = repository.save(t)
            log.debug("保存成功，数据为${schoolClass}")
            return schoolClass
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
            return if (!byId.schoolClassIsDeleted) {
                byId.schoolClassIsDeleted = true
                val schoolClass = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${schoolClass}")
                schoolClass.schoolClassIsDeleted
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
            val schoolClass = repository.delete(byId)
            log.debug("删除成功，数据为${schoolClass}")
            return true
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun updateById(id: String, t: SchoolClass): SchoolClass {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试更新ID=${id}的数据")
            val byId = selectOneById(id)
            ObjectUtils.assign(t, byId)
            val schoolClass = repository.saveAndFlush(byId)
            log.debug("更新成功，数据为${schoolClass}")
            return schoolClass
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
            return if (!byId.schoolClassIsDeleted && !byId.schoolClassIsForbidden) {
                byId.schoolClassIsForbidden = true
                val schoolClass = repository.saveAndFlush(byId)
                log.debug("逻辑删除成功，数据为${schoolClass}")
                schoolClass.schoolClassIsForbidden
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectOneById(id: String): SchoolClass {
        log.debug("传入ID为${id}")
        try {
            log.debug("尝试查找ID=${id}的数据")
            val byId = repository.findById(id)
            if (byId.isPresent) {
                val schoolClass = byId.get()
                log.debug("查找成功，数据为${schoolClass}")
                return schoolClass
            } else {
                throw InformationNotFoundException("未找到ID=${id}的对象")
            }
        } catch (e: Exception) {
            log.error(e.message)
            throw RuntimeException(e)
        }
    }

    override fun selectAllOrderBy(order: String): MutableList<SchoolClass> {
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

    override fun selectAllPageOrderBy(currentPage: Int, pageSize: Int, order: String): List<SchoolClass> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll(request)
        return findAll.toMutableList()
    }

    override fun selectLikePageOrderBy(
        currentPage: Int,
        pageSize: Int,
        order: String,
        t: SchoolClass
    ): List<SchoolClass> {
        val request = PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, order))
        val findAll = repository.findAll({ root, _, criteriaBuilder ->
            val list = mutableListOf<Predicate>()
            list.add(
                criteriaBuilder.equal(
                    root.get<SchoolClass>("schoolClassIsForbidden").`as`(Boolean::class.java),
                    t.schoolClassIsForbidden
                )
            )
            list.add(
                criteriaBuilder.equal(
                    root.get<SchoolClass>("schoolClassIsDeleted").`as`(Boolean::class.java),
                    t.schoolClassIsDeleted
                )
            )
            if (!ObjectUtils.isNullOrEmpty(t.schoolClassId)) {
                list.add(
                    criteriaBuilder.equal(
                        root.get<SchoolClass>("schoolClassId").`as`(String::class.java),
                        t.schoolClassId
                    )
                )
            }
            if (!ObjectUtils.isNullOrEmpty(t.schoolClassName)) {
                list.add(
                    criteriaBuilder.equal(
                        root.get<SchoolClass>("schoolClassName").`as`(String::class.java),
                        t.schoolClassName
                    )
                )
            }
            if (!ObjectUtils.isNullOrEmpty(t.schoolClassIsDeleted)) {
                list.add(
                    criteriaBuilder.equal(
                        root.get<SchoolClass>("schoolClassIsDeleted").`as`(String::class.java),
                        t.schoolClassIsDeleted
                    )
                )
            }
            if (!ObjectUtils.isNullOrEmpty(t.schoolClassIsForbidden)) {
                list.add(
                    criteriaBuilder.equal(
                        root.get<SchoolClass>("schoolClassIsForbidden").`as`(String::class.java),
                        t.schoolClassIsForbidden
                    )
                )
            }
            criteriaBuilder.and(*list.toTypedArray())
        }, request)

        return findAll.toMutableList()
    }

}