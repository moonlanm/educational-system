package edu.hubu.commons.mybatis.mapper;

import edu.hubu.commons.mybatis.model.Announcement;
import edu.hubu.commons.mybatis.model.AnnouncementType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementTypeMapper {
    /**
     * delete by primary key
     * @param announcementTypeId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String announcementTypeId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(AnnouncementType record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(AnnouncementType record);

    /**
     * select by primary key
     * @param announcementTypeId primary key
     * @return object by primary key
     */
    AnnouncementType selectByPrimaryKey(String announcementTypeId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(AnnouncementType record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(AnnouncementType record);

    List<AnnouncementType> selectLikePageOrderBy(int offset, int limit, String order, AnnouncementType announcementType);
}