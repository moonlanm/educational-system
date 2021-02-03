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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleId;

    private Boolean roleIsDeleted;

    private Boolean roleIsForbidden;

    private String roleName;

    private List<Admin> admins;

    private List<RolePermissionMap> rolePermissionMaps;

    private List<Student> students;

    private List<Teacher> teachers;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<RolePermissionMap> getRolePermissionMaps() {
        return rolePermissionMaps;
    }

    public void setRolePermissionMaps(List<RolePermissionMap> rolePermissionMaps) {
        this.rolePermissionMaps = rolePermissionMaps;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public Boolean getRoleIsDeleted() {
        return roleIsDeleted;
    }

    public void setRoleIsDeleted(Boolean roleIsDeleted) {
        this.roleIsDeleted = roleIsDeleted;
    }
    public Boolean getRoleIsForbidden() {
        return roleIsForbidden;
    }

    public void setRoleIsForbidden(Boolean roleIsForbidden) {
        this.roleIsForbidden = roleIsForbidden;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Role{");
        sb.append("roleId='").append(roleId).append('\'');
        sb.append(", roleIsDeleted=").append(roleIsDeleted);
        sb.append(", roleIsForbidden=").append(roleIsForbidden);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", admins=").append(admins);
        sb.append(", rolePermissionMaps=").append(rolePermissionMaps);
        sb.append(", students=").append(students);
        sb.append(", teachers=").append(teachers);
        sb.append('}');
        return sb.toString();
    }
}
