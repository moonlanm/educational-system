@file:JvmName("ObjectUtils")

package edu.hubu.commons.util

import edu.hubu.commons.annotations.FieldIgnore
import org.springframework.util.ObjectUtils
import java.lang.reflect.Array
import java.lang.reflect.Modifier
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

sealed class ObjectUtils {
    companion object {
        const val emptyString = ""

        /**
         * @param obj 需要过滤和筛选的对象
         * @return 过滤后的对象且封装了未被过滤的属性
         */
        fun <T> filter(obj: T): T {
            val clazz = obj!!::class.java
            val newInstance = clazz.getConstructor().newInstance()
            for (field in clazz.declaredFields) {
                //如果该属性需要被过滤则跳过该属性
                if (field.isAnnotationPresent(FieldIgnore::class.java)) {
                    continue
                }
                field.isAccessible = true
                val value = field.get(obj)
                //该属性的值是否为空
                if (ObjectUtils.isEmpty(value)) {
                    continue
                }
                field.set(newInstance, value)
            }
            return newInstance
        }

        /**
         * 筛选出obj的属性名和属性值
         *
         * @param obj 不能为null
         * @return 属性名和属性值键值对
         */
        fun toMap(obj: Any?): Map<String, Any> {
            if (isNullOrEmpty(obj)) {
                return emptyMap()
            }
            val map = HashMap<String, Any>()
            for (field in obj!!::class.java.declaredFields) {
                field.isAccessible = true
                val value = field.get(obj)
                //该属性的值是否为空
                if (ObjectUtils.isEmpty(value)) {
                    continue
                }
                map[field.name] = value
            }
            return map
        }

        /**
         * 将src的属性值赋值到dest中
         *
         * @param src  源对象
         * @param dest 目标对象
         */
        fun assign(src: Any, dest: Any) {
            val srcClazz = src::class.java
            val destClazz = dest::class.java
            if (srcClazz != destClazz) {
                throw IllegalArgumentException("$srcClazz != $destClazz")
            }
            for (field in srcClazz.declaredFields) {
                field.isAccessible = true
                val srcValue = field.get(src)
                if (isNullOrEmpty(srcValue)) {
                    continue
                }
                if (srcValue is ArrayList<out Any>) {
                    continue
                }

                if (srcValue is Collection<*>) {
                    continue
                }

                if (Modifier.isStatic(field.modifiers) || Modifier.isFinal(field.modifiers)) {
                    continue
                }
                
                field.set(dest, srcValue)
            }
        }

        /**
         * @param obj 需要判空的对象
         */
        fun isNullOrEmpty(obj: Any?): Boolean {
            if (obj == null) {
                return true
            }

            if (obj is Optional<*>) {
                return !obj.isPresent
            }
            if (obj is CharSequence) {
                return obj.length == 0
            }
            if (obj.javaClass.isArray) {
                return Array.getLength(obj) == 0
            }
            if (obj is Collection<*>) {
                return obj.isEmpty()
            }
            return if (obj is Map<*, *>) {
                obj.isEmpty()
            } else false
        }

        /**
         * 通过反射检查字段值
         * @param obj
         * @param fieldName 字段名
         * @param fieldValue 字段值
         * @return 是否匹配
         */
        fun reflectCheckFieldValue(obj: Any, fieldName: String, fieldValue: Any): Boolean {
            val field = obj::class.java.getDeclaredField(fieldName)
            field.isAccessible = true
            val value = field.get(obj)
            return if (isNullOrEmpty(value)) false else value == fieldValue
        }

        fun reflectGetFieldValue(obj: Any, fieldName: String): Any? {
            val field = obj::class.java.getDeclaredField(fieldName)
            field.isAccessible = true
            return field.get(obj)
        }

        fun reflectSetFieldValue(obj: Any, fieldName: String, fieldValue: Any) {
            val field = obj::class.java.getDeclaredField(fieldName)
            field.isAccessible = true
            field.set(obj, fieldValue)
        }

        fun <T> toList(obj: Any?, clazz: Class<T>): List<T> {
            if (isNullOrEmpty(obj)) {
                return emptyList()
            }
            if (obj is List<*>) {
                val list = ArrayList<T>()
                obj.forEach { any -> list.add(clazz.cast(any)) }
                return list
            }
            return emptyList()
        }

    }
}
