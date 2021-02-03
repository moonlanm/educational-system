package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.student.Student;
import edu.hubu.commons.model.teacher.Teacher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色表
 */
@Entity
@Table(name = "role")
@ApiModel("角色")
public class Role implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Role() {
        this.roleId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 角色ID
     */
    @Id
    @Column(name = "role_id", nullable = false)
    private String roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name", nullable = false)
    private String roleName;

    /**
     * 角色是否被删除
     */
    @Column(name = "role_is_deleted", nullable = false)
    private boolean roleIsDeleted = false;

    /**
     * 角色是否被封禁
     */
    @Column(name = "role_is_forbidden", nullable = false)
    private boolean roleIsForbidden = false;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Admin> admins;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<RolePermissionMap> rolePermissionMaps;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Student> students;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Teacher> teachers;

    /**
     * 角色ID
     */
    public Role setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    /**
     * 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色名称
     */
    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    /**
     * 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色是否被删除
     */
    public Role setRoleIsDeleted(boolean roleIdDeleted) {
        this.roleIsDeleted = roleIdDeleted;
        return this;
    }

    /**
     * 角色是否被删除
     */
    public boolean getRoleIsDeleted() {
        return roleIsDeleted;
    }

    /**
     * 角色是否被封禁
     */
    public Role setRoleIsForbidden(boolean roleIsForbidden) {
        this.roleIsForbidden = roleIsForbidden;
        return this;
    }

    /**
     * 角色是否被封禁
     */
    public boolean getRoleIsForbidden() {
        return roleIsForbidden;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId + '\'' +
                "roleName=" + roleName + '\'' +
                "roleIdDeleted=" + roleIsDeleted + '\'' +
                "roleIsForbidden=" + roleIsForbidden + '\'' +
                '}';
    }
}
