package edu.hubu.commons.repository.admin;

import edu.hubu.commons.model.admin.AnnouncementContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnnouncementContentRepository extends JpaRepository<AnnouncementContent, String>, JpaSpecificationExecutor<AnnouncementContent> {

}