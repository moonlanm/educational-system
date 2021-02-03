package edu.hubu.commons.model.teacher;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.annotations.FieldIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.admin.Faculty;
import edu.hubu.commons.model.admin.Major;
import edu.hubu.commons.model.admin.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 老师表
 */
@Entity
@Table(name = "teacher")
@EntityListeners(value = AuditingEntityListener.class)
@ApiModel("老师")
public class Teacher implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Teacher() {
        this.teacherId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 老师ID
     */
    @Id
    @Column(name = "teacher_id", nullable = false)
    private String teacherId;

    /**
     * 老师密码
     */
    @Column(name = "teacher_password", nullable = false)
    @FieldIgnore
    private String teacherPassword;

    /**
     * 老师姓名
     */
    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

    /**
     * 老师入校时间
     */
    @Column(name = "teacher_enter_school_time", nullable = false)
    @CreatedDate
    private LocalDateTime teacherEnterSchoolTime;

    /**
     * token
     */
    @Column(name = "teacher_token")
    private String teacherToken;

    /**
     * 老师是否被删除
     */
    @Column(name = "teacher_is_deleted", nullable = false)
    private boolean teacherIsDeleted = false;

    /**
     * 老师是否被禁用
     */
    @Column(name = "teacher_is_forbidden", nullable = false)
    private boolean teacherIsForbidden = false;

    /**
     * 老师学院ID
     */
    @ManyToOne
    @JoinColumn(name = "teacher_faculty_id", nullable = false)
    private Faculty faculty;

    /**
     * 老师专业
     */
    @ManyToOne
    @JoinColumn(name = "teacher_major_id", nullable = false)
    private Major major;

    /**
     * 老师角色
     */
    @ManyToOne
    @JoinColumn(name = "teacher_role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<TeacherCourse> teacherCourses;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<TeacherSelectCourse> teacherSelectCourses;

    /**
     * 老师ID
     */
    public Teacher setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    /**
     * 老师ID
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 老师密码
     */
    public Teacher setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
        return this;
    }

    /**
     * 老师密码
     */
    public String getTeacherPassword() {
        return teacherPassword;
    }

    /**
     * 老师姓名
     */
    public Teacher setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    /**
     * 老师姓名
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 老师入校时间
     */
    public Teacher setTeacherEnterSchoolTime(LocalDateTime teacherEnterSchoolTime) {
        this.teacherEnterSchoolTime = teacherEnterSchoolTime;
        return this;
    }

    /**
     * 老师入校时间
     */
    public LocalDateTime getTeacherEnterSchoolTime() {
        return teacherEnterSchoolTime;
    }

    /**
     * token
     */
    public Teacher setTeacherToken(String teacherToken) {
        this.teacherToken = teacherToken;
        return this;
    }

    /**
     * token
     */
    public String getTeacherToken() {
        return teacherToken;
    }

    /**
     * 老师是否被删除
     */
    public Teacher setTeacherIsDeleted(boolean teacherIsDeleted) {
        this.teacherIsDeleted = teacherIsDeleted;
        return this;
    }

    /**
     * 老师是否被删除
     */
    public boolean getTeacherIsDeleted() {
        return teacherIsDeleted;
    }

    /**
     * 老师是否被禁用
     */
    public Teacher setTeacherIsForbidden(boolean teacherIsForbidden) {
        this.teacherIsForbidden = teacherIsForbidden;
        return this;
    }

    /**
     * 老师是否被禁用
     */
    public boolean getTeacherIsForbidden() {
        return teacherIsForbidden;
    }

    /**
     * 老师学院ID
     */
    public Teacher setFaculty(Faculty teacherFacultyId) {
        this.faculty = teacherFacultyId;
        return this;
    }

    /**
     * 老师学院ID
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * 老师专业
     */
    public Teacher setMajor(Major teacherMajorId) {
        this.major = teacherMajorId;
        return this;
    }

    /**
     * 老师专业
     */
    public Major getMajor() {
        return major;
    }

    /**
     * 老师角色
     */
    public Teacher setRole(Role teacherRoleId) {
        this.role = teacherRoleId;
        return this;
    }

    /**
     * 老师角色
     */
    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId + '\'' +
                "teacherPassword=" + teacherPassword + '\'' +
                "teacherName=" + teacherName + '\'' +
                "teacherEnterSchoolTime=" + teacherEnterSchoolTime + '\'' +
                "teacherToken=" + teacherToken + '\'' +
                "teacherIsDeleted=" + teacherIsDeleted + '\'' +
                "teacherIsForbidden=" + teacherIsForbidden + '\'' +
                "faculty=" + faculty + '\'' +
                "major=" + major + '\'' +
                "role=" + role + '\'' +
                '}';
    }
}
