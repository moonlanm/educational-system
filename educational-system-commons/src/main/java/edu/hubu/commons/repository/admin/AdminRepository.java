package edu.hubu.commons.repository.admin;


import edu.hubu.commons.model.admin.Admin;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {

}