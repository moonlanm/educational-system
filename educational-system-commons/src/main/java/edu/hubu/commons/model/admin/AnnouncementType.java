package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 公告类型
 */
@Entity
@Table(name = "announcement_type")
@ApiModel("公告类型")
public class AnnouncementType implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public AnnouncementType() {
        this.announcementTypeId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 公告类型ID
     */
    @Id
    @Column(name = "announcement_type_id", nullable = false)
    private String announcementTypeId;

    /**
     * 公告类型名称
     */
    @Column(name = "announcement_type_name", nullable = false)
    private String announcementTypeName;

    /**
     * 公告类型是否被删除
     */
    @Column(name = "announcement_type_is_deleted", nullable = false)
    private boolean announcementTypeIsDeleted = false;

    /**
     * 公告类型是否被禁用
     */
    @Column(name = "announcement_type_is_forbidden", nullable = false)
    private boolean announcementTypeIsForbidden = false;

    @OneToMany(mappedBy = "announcementType")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Announcement> announcements;
    
    /**
     * 公告类型ID
     */
    public AnnouncementType setAnnouncementTypeId(String announcementTypeId) {
        this.announcementTypeId = announcementTypeId;
        return this;
    }

    /**
     * 公告类型ID
     */
    public String getAnnouncementTypeId() {
        return announcementTypeId;
    }

    /**
     * 公告类型名称
     */
    public AnnouncementType setAnnouncementTypeName(String announcementTypeName) {
        this.announcementTypeName = announcementTypeName;
        return this;
    }

    /**
     * 公告类型名称
     */
    public String getAnnouncementTypeName() {
        return announcementTypeName;
    }

    /**
     * 公告类型是否被删除
     */
    public AnnouncementType setAnnouncementTypeIsDeleted(boolean announcementTypeIsDeleted) {
        this.announcementTypeIsDeleted = announcementTypeIsDeleted;
        return this;
    }

    /**
     * 公告类型是否被删除
     */
    public boolean getAnnouncementTypeIsDeleted() {
        return announcementTypeIsDeleted;
    }

    /**
     * 公告类型是否被禁用
     */
    public AnnouncementType setAnnouncementTypeIsForbidden(boolean announcementTypeIsForbidden) {
        this.announcementTypeIsForbidden = announcementTypeIsForbidden;
        return this;
    }

    /**
     * 公告类型是否被禁用
     */
    public boolean getAnnouncementTypeIsForbidden() {
        return announcementTypeIsForbidden;
    }

    @Override
    public String toString() {
        return "AnnouncementType{" +
                "announcementTypeId=" + announcementTypeId + '\'' +
                "announcementTypeName=" + announcementTypeName + '\'' +
                "announcementTypeIsDeleted=" + announcementTypeIsDeleted + '\'' +
                "announcementTypeIsForbidden=" + announcementTypeIsForbidden + '\'' +
                '}';
    }
}
