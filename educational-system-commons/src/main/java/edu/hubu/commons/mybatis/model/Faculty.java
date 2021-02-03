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
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    private String facultyId;

    private Boolean facultyIsDeleted;

    private Boolean facultyIsForbidden;

    private String facultyName;

    private List<Major> majors;

    private List<Student> students;

    private List<Teacher> teachers;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
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

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
    public Boolean getFacultyIsDeleted() {
        return facultyIsDeleted;
    }

    public void setFacultyIsDeleted(Boolean facultyIsDeleted) {
        this.facultyIsDeleted = facultyIsDeleted;
    }
    public Boolean getFacultyIsForbidden() {
        return facultyIsForbidden;
    }

    public void setFacultyIsForbidden(Boolean facultyIsForbidden) {
        this.facultyIsForbidden = facultyIsForbidden;
    }
    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Faculty{");
        sb.append("facultyId='").append(facultyId).append('\'');
        sb.append(", facultyIsDeleted=").append(facultyIsDeleted);
        sb.append(", facultyIsForbidden=").append(facultyIsForbidden);
        sb.append(", facultyName='").append(facultyName).append('\'');
        sb.append(", majors=").append(majors);
        sb.append(", students=").append(students);
        sb.append(", teachers=").append(teachers);
        sb.append('}');
        return sb.toString();
    }
}
