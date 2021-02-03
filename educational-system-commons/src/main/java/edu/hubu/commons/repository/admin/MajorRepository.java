package edu.hubu.commons.repository.admin;

import edu.hubu.commons.model.admin.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MajorRepository extends JpaRepository<Major, String>, JpaSpecificationExecutor<Major> {

}