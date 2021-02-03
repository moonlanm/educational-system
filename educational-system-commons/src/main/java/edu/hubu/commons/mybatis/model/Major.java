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
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    private String majorId;

    private Boolean majorIsDeleted;

    private Boolean majorIsForbidden;

    private String majorName;

    private String majorFacultyId;

    private Faculty faculty;

    private List<Student> students;

    private List<Teacher> teachers;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }
    public Boolean getMajorIsDeleted() {
        return majorIsDeleted;
    }

    public void setMajorIsDeleted(Boolean majorIsDeleted) {
        this.majorIsDeleted = majorIsDeleted;
    }
    public Boolean getMajorIsForbidden() {
        return majorIsForbidden;
    }

    public void setMajorIsForbidden(Boolean majorIsForbidden) {
        this.majorIsForbidden = majorIsForbidden;
    }
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    public String getMajorFacultyId() {
        return majorFacultyId;
    }

    public void setMajorFacultyId(String majorFacultyId) {
        this.majorFacultyId = majorFacultyId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Major{");
        sb.append("majorId='").append(majorId).append('\'');
        sb.append(", majorIsDeleted=").append(majorIsDeleted);
        sb.append(", majorIsForbidden=").append(majorIsForbidden);
        sb.append(", majorName='").append(majorName).append('\'');
        sb.append(", majorFacultyId='").append(majorFacultyId).append('\'');
        sb.append(", faculty=").append(faculty);
        sb.append(", students=").append(students);
        sb.append(", teachers=").append(teachers);
        sb.append('}');
        return sb.toString();
    }
}
