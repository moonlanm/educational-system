package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import edu.hubu.commons.annotations.FieldIgnore;
import edu.hubu.commons.model.BaseModel;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 管理员表
 */
@Entity
@Table(name = "admin")
@ApiModel("管理员")
public class Admin implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Admin() {
        this.adminId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 管理员ID
     */
    @Id
    @Column(name = "admin_id", nullable = false)
    private String adminId;

    /**
     * 管理员密码
     */
    @Column(name = "admin_password", nullable = false)
    @FieldIgnore
    private String adminPassword;

    /**
     * 管理员真实姓名
     */
    @Column(name = "admin_name", nullable = false)
    private String adminName;

    /**
     * token
     */
    @Column(name = "admin_token")
    private String adminToken;

    /**
     * 管理员是否被删除
     */
    @Column(name = "admin_is_deleted", nullable = false)
    private boolean adminIsDeleted = false;

    /**
     * 管理员是否被禁用
     */
    @Column(name = "admin_is_forbidden", nullable = false)
    private boolean adminIsForbidden = false;

    /**
     * 管理员角色ID
     */
    @ManyToOne
    @JoinColumn(name = "admin_role_id", nullable = false)
    private Role role;

    /**
     * 管理员ID
     */
    public Admin setAdminId(String adminId) {
        this.adminId = adminId;
        return this;
    }

    /**
     * 管理员ID
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * 管理员密码
     */
    public Admin setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }

    /**
     * 管理员密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 管理员真实姓名
     */
    public Admin setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    /**
     * 管理员真实姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * token
     */
    public Admin setAdminToken(String adminToken) {
        this.adminToken = adminToken;
        return this;
    }

    /**
     * token
     */
    public String getAdminToken() {
        return adminToken;
    }

    /**
     * 管理员是否被删除
     */
    public Admin setAdminIsDeleted(boolean adminIsDeleted) {
        this.adminIsDeleted = adminIsDeleted;
        return this;
    }

    /**
     * 管理员是否被删除
     */
    public boolean getAdminIsDeleted() {
        return adminIsDeleted;
    }

    /**
     * 管理员是否被禁用
     */
    public Admin setAdminIsForbidden(boolean adminIsForbidden) {
        this.adminIsForbidden = adminIsForbidden;
        return this;
    }

    /**
     * 管理员是否被禁用
     */
    public boolean getAdminIsForbidden() {
        return adminIsForbidden;
    }

    /**
     * 管理员角色ID
     */
    public Admin setRole(Role adminRoleId) {
        this.role = adminRoleId;
        return this;
    }

    /**
     * 管理员角色ID
     */
    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId + '\'' +
                "adminPassword=" + adminPassword + '\'' +
                "adminName=" + adminName + '\'' +
                "adminToken=" + adminToken + '\'' +
                "adminIsDeleted=" + adminIsDeleted + '\'' +
                "adminIsForbidden=" + adminIsForbidden + '\'' +
                "role=" + role + '\'' +
                '}';
    }
}
