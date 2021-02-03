package edu.hubu.commons.repository.admin;

import edu.hubu.commons.model.admin.AnnouncementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AnnouncementTypeRepository extends JpaRepository<AnnouncementType, String>, JpaSpecificationExecutor<AnnouncementType> {

}