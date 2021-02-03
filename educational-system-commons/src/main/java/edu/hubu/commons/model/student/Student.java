package edu.hubu.commons.model.student;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.annotations.FieldIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.SchoolClass;
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
 * 学生表
 */
@Entity
@Table(name = "student")
@EntityListeners(value = AuditingEntityListener.class)
@ApiModel("学生")
public class Student implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Student() {
        this.studentId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 学生ID
     */
    @Id
    @Column(name = "student_id", nullable = false)
    private String studentId;

    /**
     * 学生密码
     */
    @Column(name = "student_password", nullable = false)
    @FieldIgnore
    private String studentPassword;

    /**
     * 学生姓名
     */
    @Column(name = "student_name", nullable = false)
    private String studentName;

    /**
     * 学生入校时间
     */
    @Column(name = "student_enter_school_time", nullable = false)
    @CreatedDate
    private LocalDateTime studentEnterSchoolTime;

    /**
     * token
     */
    @Column(name = "student_token")
    private String studentToken;

    /**
     * 学生是否被删除
     */
    @Column(name = "student_is_deleted", nullable = false)
    private boolean studentIsDeleted = false;

    /**
     * 学生是否被禁用
     */
    @Column(name = "student_is_forbidden", nullable = false)
    private boolean studentIsForbidden = false;

    /**
     * 学生学院ID
     */
    @ManyToOne
    @JoinColumn(name = "student_faculty_id", nullable = false)
    private Faculty faculty;

    /**
     * 学生专业
     */
    @ManyToOne
    @JoinColumn(name = "student_major_id", nullable = false)
    private Major major;

    /**
     * 学生班级ID
     */
    @ManyToOne
    @JoinColumn(name = "student_class_id", nullable = false)
    private SchoolClass schoolClass;

    /**
     * 学生角色
     */
    @ManyToOne
    @JoinColumn(name = "student_role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentScore> studentScores;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentSelectCourse> studentSelectCourses;

    /**
     * 学生ID
     */
    public Student setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    /**
     * 学生ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 学生密码
     */
    public Student setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
        return this;
    }

    /**
     * 学生密码
     */
    public String getStudentPassword() {
        return studentPassword;
    }

    /**
     * 学生姓名
     */
    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    /**
     * 学生姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 学生入校时间
     */
    public Student setStudentEnterSchoolTime(LocalDateTime studentEnterSchoolTime) {
        this.studentEnterSchoolTime = studentEnterSchoolTime;
        return this;
    }

    /**
     * 学生入校时间
     */
    public LocalDateTime getStudentEnterSchoolTime() {
        return studentEnterSchoolTime;
    }

    /**
     * token
     */
    public Student setStudentToken(String studentToken) {
        this.studentToken = studentToken;
        return this;
    }

    /**
     * token
     */
    public String getStudentToken() {
        return studentToken;
    }

    /**
     * 学生是否被删除
     */
    public Student setStudentIsDeleted(boolean studentIsDeleted) {
        this.studentIsDeleted = studentIsDeleted;
        return this;
    }

    /**
     * 学生是否被删除
     */
    public boolean getStudentIsDeleted() {
        return studentIsDeleted;
    }

    /**
     * 学生是否被禁用
     */
    public Student setStudentIsForbidden(boolean studentIsForbidden) {
        this.studentIsForbidden = studentIsForbidden;
        return this;
    }

    /**
     * 学生是否被禁用
     */
    public boolean getStudentIsForbidden() {
        return studentIsForbidden;
    }

    /**
     * 学生学院ID
     */
    public Student setFaculty(Faculty studentFacultyId) {
        this.faculty = studentFacultyId;
        return this;
    }

    /**
     * 学生学院ID
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * 学生专业
     */
    public Student setMajor(Major studentMajorId) {
        this.major = studentMajorId;
        return this;
    }

    /**
     * 学生专业
     */
    public Major getMajor() {
        return major;
    }

    /**
     * 学生班级ID
     */
    public Student setSchoolClass(SchoolClass studentClassId) {
        this.schoolClass = studentClassId;
        return this;
    }

    /**
     * 学生班级ID
     */
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    /**
     * 学生角色
     */
    public Student setRole(Role studentRoleId) {
        this.role = studentRoleId;
        return this;
    }

    /**
     * 学生角色
     */
    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId + '\'' +
                "studentPassword=" + studentPassword + '\'' +
                "studentName=" + studentName + '\'' +
                "studentEnterSchoolTime=" + studentEnterSchoolTime + '\'' +
                "studentToken=" + studentToken + '\'' +
                "studentIsDeleted=" + studentIsDeleted + '\'' +
                "studentIsForbidden=" + studentIsForbidden + '\'' +
                "faculty=" + faculty + '\'' +
                "major=" + major + '\'' +
                "schoolClass=" + schoolClass + '\'' +
                "role=" + role + '\'' +
                '}';
    }
}
