package edu.hubu.commons.repository;

import edu.hubu.commons.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, String>, JpaSpecificationExecutor<SchoolClass> {

}