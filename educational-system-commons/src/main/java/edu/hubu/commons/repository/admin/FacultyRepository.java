package edu.hubu.commons.repository.admin;

import edu.hubu.commons.model.admin.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacultyRepository extends JpaRepository<Faculty, String>, JpaSpecificationExecutor<Faculty> {

}