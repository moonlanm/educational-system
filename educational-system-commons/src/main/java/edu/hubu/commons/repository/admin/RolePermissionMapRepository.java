package edu.hubu.commons.repository.admin;

import edu.hubu.commons.model.admin.RolePermissionMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolePermissionMapRepository extends JpaRepository<RolePermissionMap, String>, JpaSpecificationExecutor<RolePermissionMap> {

}