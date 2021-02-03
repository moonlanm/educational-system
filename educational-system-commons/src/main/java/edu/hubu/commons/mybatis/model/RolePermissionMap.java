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
public class RolePermissionMap implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rolePermissionId;

    private String rolePermissionPermissionId;

    private String rolePermissionRoleId;

    public String getRolePermissionId() {
        return rolePermissionId;
    }

    private Role role;

    private Permission permission;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }
    public String getRolePermissionPermissionId() {
        return rolePermissionPermissionId;
    }

    public void setRolePermissionPermissionId(String rolePermissionPermissionId) {
        this.rolePermissionPermissionId = rolePermissionPermissionId;
    }
    public String getRolePermissionRoleId() {
        return rolePermissionRoleId;
    }

    public void setRolePermissionRoleId(String rolePermissionRoleId) {
        this.rolePermissionRoleId = rolePermissionRoleId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RolePermissionMap{");
        sb.append("rolePermissionId='").append(rolePermissionId).append('\'');
        sb.append(", rolePermissionPermissionId='").append(rolePermissionPermissionId).append('\'');
        sb.append(", rolePermissionRoleId='").append(rolePermissionRoleId).append('\'');
        sb.append(", role=").append(role);
        sb.append(", permission=").append(permission);
        sb.append('}');
        return sb.toString();
    }
}
