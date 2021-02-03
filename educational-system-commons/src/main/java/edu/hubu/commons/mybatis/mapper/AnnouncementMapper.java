package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Admin;
import edu.hubu.commons.mybatis.model.Announcement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementMapper {
    /**
     * delete by primary key
     * @param announcementId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String announcementId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Announcement record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Announcement record);

    /**
     * select by primary key
     * @param announcementId primary key
     * @return object by primary key
     */
    Announcement selectByPrimaryKey(String announcementId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Announcement record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Announcement record);

    List<Announcement> selectLikePageOrderBy(int offset, int limit, String order, Announcement announcement);
}