package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import edu.hubu.commons.model.BaseModel;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色权限映射表
 */
@Entity
@Table(name = "role_permission_map")
@ApiModel("角色权限映射")
public class RolePermissionMap implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public RolePermissionMap() {
        this.rolePermissionId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 角色权限表ID
     */
    @Id
    @Column(name = "role_permission_id", nullable = false)
    private String rolePermissionId;

    /**
     * 角色ID
     */
    @ManyToOne
    @JoinColumn(name = "role_permission_role_id", nullable = false)
    private Role role;

    /**
     * 权限ID
     */
    @ManyToOne
    @JoinColumn(name = "role_permission_permission_id", nullable = false)
    private Permission permission;

    /**
     * 角色权限表ID
     */
    public RolePermissionMap setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
        return this;
    }

    /**
     * 角色权限表ID
     */
    public String getRolePermissionId() {
        return rolePermissionId;
    }

    /**
     * 角色ID
     */
    public RolePermissionMap setRole(Role rolePermissionRoleId) {
        this.role = rolePermissionRoleId;
        return this;
    }

    /**
     * 角色ID
     */
    public Role getRole() {
        return role;
    }

    /**
     * 权限ID
     */
    public RolePermissionMap setPermission(Permission rolePermissionPermissionId) {
        this.permission = rolePermissionPermissionId;
        return this;
    }

    /**
     * 权限ID
     */
    public Permission getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return "RolePermissionMap{" +
                "rolePermissionId=" + rolePermissionId + '\'' +
                "role=" + role + '\'' +
                "permission=" + permission + '\'' +
                '}';
    }
}
