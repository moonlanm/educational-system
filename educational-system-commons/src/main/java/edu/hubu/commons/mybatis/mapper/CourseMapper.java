package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.AnnouncementType;
import edu.hubu.commons.mybatis.model.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    /**
     * delete by primary key
     * @param courseId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String courseId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Course record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Course record);

    /**
     * select by primary key
     * @param courseId primary key
     * @return object by primary key
     */
    Course selectByPrimaryKey(String courseId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Course record);

    List<Course> selectLikePageOrderBy(int offset, int limit, String order, Course course);
}