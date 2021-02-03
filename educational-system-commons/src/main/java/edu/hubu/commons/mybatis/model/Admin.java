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
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String adminId;

    private Boolean adminIsDeleted;

    private Boolean adminIsForbidden;

    private String adminName;

    private String adminPassword;

    private String adminToken;

    private String adminRoleId;

    private Role role;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Boolean getAdminIsDeleted() {
        return adminIsDeleted;
    }

    public void setAdminIsDeleted(Boolean adminIsDeleted) {
        this.adminIsDeleted = adminIsDeleted;
    }

    public Boolean getAdminIsForbidden() {
        return adminIsForbidden;
    }

    public void setAdminIsForbidden(Boolean adminIsForbidden) {
        this.adminIsForbidden = adminIsForbidden;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }

    public String getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(String adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Admin{");
        sb.append("adminId='").append(adminId).append('\'');
        sb.append(", adminIsDeleted=").append(adminIsDeleted);
        sb.append(", adminIsForbidden=").append(adminIsForbidden);
        sb.append(", adminName='").append(adminName).append('\'');
        sb.append(", adminPassword='").append(adminPassword).append('\'');
        sb.append(", adminToken='").append(adminToken).append('\'');
        sb.append(", adminRoleId='").append(adminRoleId).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
