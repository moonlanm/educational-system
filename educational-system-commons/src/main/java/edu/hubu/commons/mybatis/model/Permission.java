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
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private String permissionId;

    private Boolean permissionIsDeleted;

    private Boolean permissionIsForbidden;

    private String permissionName;

    private List<RolePermissionMap> rolePermissionMaps;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<RolePermissionMap> getRolePermissionMaps() {
        return rolePermissionMaps;
    }

    public void setRolePermissionMaps(List<RolePermissionMap> rolePermissionMaps) {
        this.rolePermissionMaps = rolePermissionMaps;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
    public Boolean getPermissionIsDeleted() {
        return permissionIsDeleted;
    }

    public void setPermissionIsDeleted(Boolean permissionIsDeleted) {
        this.permissionIsDeleted = permissionIsDeleted;
    }
    public Boolean getPermissionIsForbidden() {
        return permissionIsForbidden;
    }

    public void setPermissionIsForbidden(Boolean permissionIsForbidden) {
        this.permissionIsForbidden = permissionIsForbidden;
    }
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Permission{");
        sb.append("permissionId='").append(permissionId).append('\'');
        sb.append(", permissionIsDeleted=").append(permissionIsDeleted);
        sb.append(", permissionIsForbidden=").append(permissionIsForbidden);
        sb.append(", permissionName='").append(permissionName).append('\'');
        sb.append(", rolePermissionMaps=").append(rolePermissionMaps);
        sb.append('}');
        return sb.toString();
    }
}
