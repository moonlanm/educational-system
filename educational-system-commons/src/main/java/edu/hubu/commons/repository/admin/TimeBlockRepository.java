package edu.hubu.commons.repository.admin;

import edu.hubu.commons.model.admin.TimeBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TimeBlockRepository extends JpaRepository<TimeBlock, String>, JpaSpecificationExecutor<TimeBlock> {

}