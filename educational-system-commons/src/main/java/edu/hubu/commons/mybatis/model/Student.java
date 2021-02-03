package edu.hubu.commons.mybatis.model;

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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentId;

    private LocalDateTime studentEnterSchoolTime;

    private Boolean studentIsDeleted;

    private Boolean studentIsForbidden;

    private String studentName;

    private String studentPassword;

    private String studentToken;

    private String studentFacultyId;

    private String studentMajorId;

    private String studentRoleId;

    private String studentClassId;

    private Faculty faculty;

    private Major major;

    private SchoolClass schoolClass;

    private Role role;

    private List<StudentCourse> studentCourses;

    private List<StudentScore> studentScores;

    private List<StudentSelectCourse> studentSelectCourses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public List<StudentScore> getStudentScores() {
        return studentScores;
    }

    public void setStudentScores(List<StudentScore> studentScores) {
        this.studentScores = studentScores;
    }

    public List<StudentSelectCourse> getStudentSelectCourses() {
        return studentSelectCourses;
    }

    public void setStudentSelectCourses(List<StudentSelectCourse> studentSelectCourses) {
        this.studentSelectCourses = studentSelectCourses;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public LocalDateTime getStudentEnterSchoolTime() {
        return studentEnterSchoolTime;
    }

    public void setStudentEnterSchoolTime(LocalDateTime studentEnterSchoolTime) {
        this.studentEnterSchoolTime = studentEnterSchoolTime;
    }
    public Boolean getStudentIsDeleted() {
        return studentIsDeleted;
    }

    public void setStudentIsDeleted(Boolean studentIsDeleted) {
        this.studentIsDeleted = studentIsDeleted;
    }
    public Boolean getStudentIsForbidden() {
        return studentIsForbidden;
    }

    public void setStudentIsForbidden(Boolean studentIsForbidden) {
        this.studentIsForbidden = studentIsForbidden;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
    public String getStudentToken() {
        return studentToken;
    }

    public void setStudentToken(String studentToken) {
        this.studentToken = studentToken;
    }
    public String getStudentFacultyId() {
        return studentFacultyId;
    }

    public void setStudentFacultyId(String studentFacultyId) {
        this.studentFacultyId = studentFacultyId;
    }
    public String getStudentMajorId() {
        return studentMajorId;
    }

    public void setStudentMajorId(String studentMajorId) {
        this.studentMajorId = studentMajorId;
    }
    public String getStudentRoleId() {
        return studentRoleId;
    }

    public void setStudentRoleId(String studentRoleId) {
        this.studentRoleId = studentRoleId;
    }
    public String getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(String studentClassId) {
        this.studentClassId = studentClassId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("studentId='").append(studentId).append('\'');
        sb.append(", studentEnterSchoolTime=").append(studentEnterSchoolTime);
        sb.append(", studentIsDeleted=").append(studentIsDeleted);
        sb.append(", studentIsForbidden=").append(studentIsForbidden);
        sb.append(", studentName='").append(studentName).append('\'');
        sb.append(", studentPassword='").append(studentPassword).append('\'');
        sb.append(", studentToken='").append(studentToken).append('\'');
        sb.append(", studentFacultyId='").append(studentFacultyId).append('\'');
        sb.append(", studentMajorId='").append(studentMajorId).append('\'');
        sb.append(", studentRoleId='").append(studentRoleId).append('\'');
        sb.append(", studentClassId='").append(studentClassId).append('\'');
        sb.append(", faculty=").append(faculty);
        sb.append(", major=").append(major);
        sb.append(", schoolClass=").append(schoolClass);
        sb.append(", role=").append(role);
        sb.append(", studentCourses=").append(studentCourses);
        sb.append(", studentScores=").append(studentScores);
        sb.append(", studentSelectCourses=").append(studentSelectCourses);
        sb.append('}');
        return sb.toString();
    }
}
