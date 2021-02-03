package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色表
 */
@Entity
@Table(name = "permission")
@ApiModel("权限")
public class Permission implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Permission() {
        this.permissionId = IdUtil.simpleUUID().substring(0, 6);
    }

    @Id
    @Column(name = "permission_id", nullable = false)
    private String permissionId;

    /**
     * 权限名称
     */
    @Column(name = "permission_name", nullable = false)
    private String permissionName;

    /**
     * 权限是否被删除
     */
    @Column(name = "permission_is_deleted", nullable = false)
    private boolean permissionIsDeleted = false;

    /**
     * 权限是否被禁用
     */
    @Column(name = "permission_is_forbidden", nullable = false)
    private boolean permissionIsForbidden = false;

    @OneToMany(mappedBy = "permission")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<RolePermissionMap> rolePermissionMaps;

    public Permission setPermissionId(String permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    public String getPermissionId() {
        return permissionId;
    }

    /**
     * 权限名称
     */
    public Permission setPermissionName(String permissionName) {
        this.permissionName = permissionName;
        return this;
    }

    /**
     * 权限名称
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 权限是否被删除
     */
    public Permission setPermissionIsDeleted(boolean permissionIsDeleted) {
        this.permissionIsDeleted = permissionIsDeleted;
        return this;
    }

    /**
     * 权限是否被删除
     */
    public boolean getPermissionIsDeleted() {
        return permissionIsDeleted;
    }

    /**
     * 权限是否被禁用
     */
    public Permission setPermissionIsForbidden(boolean permissionIsForbidden) {
        this.permissionIsForbidden = permissionIsForbidden;
        return this;
    }

    /**
     * 权限是否被禁用
     */
    public boolean getPermissionIsForbidden() {
        return permissionIsForbidden;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId + '\'' +
                "permissionName=" + permissionName + '\'' +
                "permissionIsDeleted=" + permissionIsDeleted + '\'' +
                "permissionIsForbidden=" + permissionIsForbidden + '\'' +
                '}';
    }
}
