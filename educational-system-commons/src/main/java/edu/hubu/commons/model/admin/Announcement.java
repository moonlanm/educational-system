package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 公告
 */
@Entity
@Table(name = "announcement")
@ApiModel("公告")
@EntityListeners(value = AuditingEntityListener.class)
public class Announcement implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Announcement() {
        this.announcementId = IdUtil.simpleUUID().substring(0, 6);
    }
    
    /**
     * 公告ID
     */
    @Id
    @Column(name = "announcement_id", nullable = false)
    private String announcementId;

    /**
     * 公告标题
     */
    @Column(name = "announcement_title", nullable = false)
    private String announcementTitle;

    /**
     * 公告阅读数
     */
    @Column(name = "announcement_read_number", nullable = false)
    private Long announcementReadNumber;

    /**
     * 公告发布时间
     */
    @Column(name = "announcement_publish_time", nullable = false)
    @CreatedDate
    private LocalDateTime announcementPublishTime;

    /**
     * 公告是否被删除
     */
    @Column(name = "announcement_is_deleted", nullable = false)
    private boolean announcementIsDeleted = false;

    /**
     * 公告是否被禁止
     */
    @Column(name = "announcement_is_forbidden", nullable = false)
    private boolean announcementIsForbidden = false;

    /**
     * 公告类型ID
     */
    @ManyToOne
    @JoinColumn(name = "announcement_announcement_type_id", nullable = false)
    private AnnouncementType announcementType;

    @OneToMany(mappedBy = "announcement")
    @JsonIgnore
    private List<AnnouncementContent> announcementContents;

    /**
     * 公告ID
     */
    public Announcement setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
        return this;
    }

    /**
     * 公告ID
     */
    public String getAnnouncementId() {
        return announcementId;
    }

    /**
     * 公告标题
     */
    public Announcement setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
        return this;
    }

    /**
     * 公告标题
     */
    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    /**
     * 公告阅读数
     */
    public Announcement setAnnouncementReadNumber(Long announcementReadNumber) {
        this.announcementReadNumber = announcementReadNumber;
        return this;
    }

    /**
     * 公告阅读数
     */
    public Long getAnnouncementReadNumber() {
        return announcementReadNumber;
    }

    /**
     * 公告发布时间
     */
    public Announcement setAnnouncementPublishTime(LocalDateTime announcementPublishTime) {
        this.announcementPublishTime = announcementPublishTime;
        return this;
    }

    /**
     * 公告发布时间
     */
    public LocalDateTime getAnnouncementPublishTime() {
        return announcementPublishTime;
    }

    /**
     * 公告是否被删除
     */
    public Announcement setAnnouncementIsDeleted(boolean announcementIsDeleted) {
        this.announcementIsDeleted = announcementIsDeleted;
        return this;
    }

    /**
     * 公告是否被删除
     */
    public boolean getAnnouncementIsDeleted() {
        return announcementIsDeleted;
    }

    /**
     * 公告是否被禁止
     */
    public Announcement setAnnouncementIsForbidden(boolean announcementIsForbidden) {
        this.announcementIsForbidden = announcementIsForbidden;
        return this;
    }

    /**
     * 公告是否被禁止
     */
    public boolean getAnnouncementIsForbidden() {
        return announcementIsForbidden;
    }

    /**
     * 公告类型ID
     */
    public Announcement setAnnouncementType(AnnouncementType announcementAnnouncementTypeId) {
        this.announcementType = announcementAnnouncementTypeId;
        return this;
    }

    /**
     * 公告类型ID
     */
    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId + '\'' +
                "announcementTitle=" + announcementTitle + '\'' +
                "announcementReadNumber=" + announcementReadNumber + '\'' +
                "announcementPublishTime=" + announcementPublishTime + '\'' +
                "announcementIsDeleted=" + announcementIsDeleted + '\'' +
                "announcementIsForbidden=" + announcementIsForbidden + '\'' +
                "announcementType=" + announcementType + '\'' +
                '}';
    }
}
