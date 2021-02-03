package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Admin;
import edu.hubu.commons.mybatis.model.AnnouncementContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementContentMapper {
    /**
     * delete by primary key
     * @param announcementContentId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String announcementContentId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(AnnouncementContent record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(AnnouncementContent record);

    /**
     * select by primary key
     * @param announcementContentId primary key
     * @return object by primary key
     */
    AnnouncementContent selectByPrimaryKey(String announcementContentId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(AnnouncementContent record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(AnnouncementContent record);

}