package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import edu.hubu.commons.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 公告内容
 */
@Entity
@Table(name = "announcement_content")
@ApiModel("公告内容")
public class AnnouncementContent implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public AnnouncementContent() {
        this.announcementContentId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 公告内容ID
     */
    @Id
    @Column(name = "announcement_content_id", nullable = false)
    private String announcementContentId;

    /**
     * 公告内容
     */
    @Column(name = "announcement_content_text")
    private String announcementContentText;

    /**
     * 公告ID
     */
    @ManyToOne
    @JoinColumn(name = "announcement_content_announcement_id", nullable = false)
    @ApiModelProperty(hidden = true)
    private Announcement announcement;

    /**
     * 公告内容ID
     */
    public AnnouncementContent setAnnouncementContentId(String announcementContentId) {
        this.announcementContentId = announcementContentId;
        return this;
    }

    /**
     * 公告内容ID
     */
    public String getAnnouncementContentId() {
        return announcementContentId;
    }

    /**
     * 公告内容
     */
    public AnnouncementContent setAnnouncementContentText(String announcementContentText) {
        this.announcementContentText = announcementContentText;
        return this;
    }

    /**
     * 公告内容
     */
    public String getAnnouncementContentText() {
        return announcementContentText;
    }

    /**
     * 公告ID
     */
    public AnnouncementContent setAnnouncement(Announcement announcementContentAnnouncementId) {
        this.announcement = announcementContentAnnouncementId;
        return this;
    }

    /**
     * 公告ID
     */
    public Announcement getAnnouncement() {
        return announcement;
    }

    @Override
    public String toString() {
        return "AnnouncementContent{" +
                "announcementContentId=" + announcementContentId + '\'' +
                "announcementContentText=" + announcementContentText + '\'' +
                "announcement=" + announcement + '\'' +
                '}';
    }
}
