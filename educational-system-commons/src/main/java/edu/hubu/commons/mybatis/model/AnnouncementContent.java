package edu.hubu.commons.mybatis.model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author moonlan
 * @since 2021-02-01
 */
public class AnnouncementContent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String announcementContentId;

    private String announcementContentText;

    private String announcementContentAnnouncementId;

    private Announcement announcement;

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public String getAnnouncementContentId() {
        return announcementContentId;
    }

    public void setAnnouncementContentId(String announcementContentId) {
        this.announcementContentId = announcementContentId;
    }
    public String getAnnouncementContentText() {
        return announcementContentText;
    }

    public void setAnnouncementContentText(String announcementContentText) {
        this.announcementContentText = announcementContentText;
    }
    public String getAnnouncementContentAnnouncementId() {
        return announcementContentAnnouncementId;
    }

    public void setAnnouncementContentAnnouncementId(String announcementContentAnnouncementId) {
        this.announcementContentAnnouncementId = announcementContentAnnouncementId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AnnouncementContent{");
        sb.append("announcementContentId='").append(announcementContentId).append('\'');
        sb.append(", announcementContentText='").append(announcementContentText).append('\'');
        sb.append(", announcementContentAnnouncementId='").append(announcementContentAnnouncementId).append('\'');
        sb.append(", announcement=").append(announcement);
        sb.append('}');
        return sb.toString();
    }
}
