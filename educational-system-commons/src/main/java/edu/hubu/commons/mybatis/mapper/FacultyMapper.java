package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Course;
import edu.hubu.commons.mybatis.model.Faculty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FacultyMapper {
    /**
     * delete by primary key
     * @param facultyId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String facultyId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Faculty record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Faculty record);

    /**
     * select by primary key
     * @param facultyId primary key
     * @return object by primary key
     */
    Faculty selectByPrimaryKey(String facultyId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Faculty record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Faculty record);

    List<Faculty> selectLikePageOrderBy(int offset, int limit, String order, Faculty faculty);

}