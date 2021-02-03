package edu.hubu.commons.mybatis.model;

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
public class AnnouncementType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String announcementTypeId;

    private Boolean announcementTypeIsDeleted;

    private Boolean announcementTypeIsForbidden;

    private String announcementTypeName;

    private List<Announcement> announcements;

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public String getAnnouncementTypeId() {
        return announcementTypeId;
    }

    public void setAnnouncementTypeId(String announcementTypeId) {
        this.announcementTypeId = announcementTypeId;
    }
    public Boolean getAnnouncementTypeIsDeleted() {
        return announcementTypeIsDeleted;
    }

    public void setAnnouncementTypeIsDeleted(Boolean announcementTypeIsDeleted) {
        this.announcementTypeIsDeleted = announcementTypeIsDeleted;
    }
    public Boolean getAnnouncementTypeIsForbidden() {
        return announcementTypeIsForbidden;
    }

    public void setAnnouncementTypeIsForbidden(Boolean announcementTypeIsForbidden) {
        this.announcementTypeIsForbidden = announcementTypeIsForbidden;
    }
    public String getAnnouncementTypeName() {
        return announcementTypeName;
    }

    public void setAnnouncementTypeName(String announcementTypeName) {
        this.announcementTypeName = announcementTypeName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AnnouncementType{");
        sb.append("announcementTypeId='").append(announcementTypeId).append('\'');
        sb.append(", announcementTypeIsDeleted=").append(announcementTypeIsDeleted);
        sb.append(", announcementTypeIsForbidden=").append(announcementTypeIsForbidden);
        sb.append(", announcementTypeName='").append(announcementTypeName).append('\'');
        sb.append(", announcements=").append(announcements);
        sb.append('}');
        return sb.toString();
    }
}
