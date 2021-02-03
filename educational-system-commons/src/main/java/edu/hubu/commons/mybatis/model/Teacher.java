package edu.hubu.commons.mybatis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
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
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    private String teacherId;

    private LocalDateTime teacherEnterSchoolTime;

    private Boolean teacherIsDeleted;

    private Boolean teacherIsForbidden;

    private String teacherName;

    private String teacherPassword;

    private String teacherToken;

    private String teacherFacultyId;

    private String teacherMajorId;

    private String teacherRoleId;

    private Role role;

    private List<TeacherCourse> teacherCourses;

    private List<TeacherSelectCourse> teacherSelectCourses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<TeacherCourse> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(List<TeacherCourse> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    public List<TeacherSelectCourse> getTeacherSelectCourses() {
        return teacherSelectCourses;
    }

    public void setTeacherSelectCourses(List<TeacherSelectCourse> teacherSelectCourses) {
        this.teacherSelectCourses = teacherSelectCourses;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public LocalDateTime getTeacherEnterSchoolTime() {
        return teacherEnterSchoolTime;
    }

    public void setTeacherEnterSchoolTime(LocalDateTime teacherEnterSchoolTime) {
        this.teacherEnterSchoolTime = teacherEnterSchoolTime;
    }
    public Boolean getTeacherIsDeleted() {
        return teacherIsDeleted;
    }

    public void setTeacherIsDeleted(Boolean teacherIsDeleted) {
        this.teacherIsDeleted = teacherIsDeleted;
    }
    public Boolean getTeacherIsForbidden() {
        return teacherIsForbidden;
    }

    public void setTeacherIsForbidden(Boolean teacherIsForbidden) {
        this.teacherIsForbidden = teacherIsForbidden;
    }
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
    public String getTeacherToken() {
        return teacherToken;
    }

    public void setTeacherToken(String teacherToken) {
        this.teacherToken = teacherToken;
    }
    public String getTeacherFacultyId() {
        return teacherFacultyId;
    }

    public void setTeacherFacultyId(String teacherFacultyId) {
        this.teacherFacultyId = teacherFacultyId;
    }
    public String getTeacherMajorId() {
        return teacherMajorId;
    }

    public void setTeacherMajorId(String teacherMajorId) {
        this.teacherMajorId = teacherMajorId;
    }
    public String getTeacherRoleId() {
        return teacherRoleId;
    }

    public void setTeacherRoleId(String teacherRoleId) {
        this.teacherRoleId = teacherRoleId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Teacher{");
        sb.append("teacherId='").append(teacherId).append('\'');
        sb.append(", teacherEnterSchoolTime=").append(teacherEnterSchoolTime);
        sb.append(", teacherIsDeleted=").append(teacherIsDeleted);
        sb.append(", teacherIsForbidden=").append(teacherIsForbidden);
        sb.append(", teacherName='").append(teacherName).append('\'');
        sb.append(", teacherPassword='").append(teacherPassword).append('\'');
        sb.append(", teacherToken='").append(teacherToken).append('\'');
        sb.append(", teacherFacultyId='").append(teacherFacultyId).append('\'');
        sb.append(", teacherMajorId='").append(teacherMajorId).append('\'');
        sb.append(", teacherRoleId='").append(teacherRoleId).append('\'');
        sb.append(", role=").append(role);
        sb.append(", teacherCourses=").append(teacherCourses);
        sb.append(", teacherSelectCourses=").append(teacherSelectCourses);
        sb.append('}');
        return sb.toString();
    }
}
