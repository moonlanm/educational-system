package edu.hubu.commons.mybatis.model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author moonlan
 * @since 2021-02-01
 */
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    private String announcementId;

    private Boolean announcementIsDeleted;

    private Boolean announcementIsForbidden;

    private LocalDateTime announcementPublishTime;

    private Long announcementReadNumber;

    private String announcementTitle;

    private String announcementAnnouncementTypeId;

    private AnnouncementType announcementType;

    private List<AnnouncementContent> announcementContents;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    public void setAnnouncementType(AnnouncementType announcementType) {
        this.announcementType = announcementType;
    }

    public List<AnnouncementContent> getAnnouncementContents() {
        return announcementContents;
    }

    public void setAnnouncementContents(List<AnnouncementContent> announcementContents) {
        this.announcementContents = announcementContents;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }
    public Boolean getAnnouncementIsDeleted() {
        return announcementIsDeleted;
    }

    public void setAnnouncementIsDeleted(Boolean announcementIsDeleted) {
        this.announcementIsDeleted = announcementIsDeleted;
    }
    public Boolean getAnnouncementIsForbidden() {
        return announcementIsForbidden;
    }

    public void setAnnouncementIsForbidden(Boolean announcementIsForbidden) {
        this.announcementIsForbidden = announcementIsForbidden;
    }
    public LocalDateTime getAnnouncementPublishTime() {
        return announcementPublishTime;
    }

    public void setAnnouncementPublishTime(LocalDateTime announcementPublishTime) {
        this.announcementPublishTime = announcementPublishTime;
    }
    public Long getAnnouncementReadNumber() {
        return announcementReadNumber;
    }

    public void setAnnouncementReadNumber(Long announcementReadNumber) {
        this.announcementReadNumber = announcementReadNumber;
    }
    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }
    public String getAnnouncementAnnouncementTypeId() {
        return announcementAnnouncementTypeId;
    }

    public void setAnnouncementAnnouncementTypeId(String announcementAnnouncementTypeId) {
        this.announcementAnnouncementTypeId = announcementAnnouncementTypeId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Announcement{");
        sb.append("announcementId='").append(announcementId).append('\'');
        sb.append(", announcementIsDeleted=").append(announcementIsDeleted);
        sb.append(", announcementIsForbidden=").append(announcementIsForbidden);
        sb.append(", announcementPublishTime=").append(announcementPublishTime);
        sb.append(", announcementReadNumber=").append(announcementReadNumber);
        sb.append(", announcementTitle='").append(announcementTitle).append('\'');
        sb.append(", announcementAnnouncementTypeId='").append(announcementAnnouncementTypeId).append('\'');
        sb.append(", announcementType=").append(announcementType);
        sb.append(", announcementContents=").append(announcementContents);
        sb.append('}');
        return sb.toString();
    }
}
