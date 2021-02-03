package edu.hubu.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.admin.Faculty;
import edu.hubu.commons.model.admin.Major;
import edu.hubu.commons.model.student.Student;
import edu.hubu.commons.model.teacher.Teacher;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 班级
 */
@Table(name = "school_class")
@Entity
public class SchoolClass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 班级ID
     */
    @Id
    @Column(name = "school_class_id", nullable = false)
    private String schoolClassId;

    /**
     * 班级名称
     */
    @Column(name = "school_class_name", nullable = false)
    private String schoolClassName;

    /**
     * 专业是否被删除
     */
    @Column(name = "school_class_is_deleted", nullable = false)
    private boolean schoolClassIsDeleted;

    /**
     * 专业是否被禁用
     */
    @Column(name = "school_class_is_forbidden", nullable = false)
    private boolean schoolClassIsForbidden;

    @ManyToOne
    @JoinColumn(name = "school_class_faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "school_class_major_id", nullable = false)
    private Major major;

    @ManyToOne
    @JoinColumn(name = "school_class_teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "schoolClass")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Student> students;

    /**
     * 班级ID
     */
    public SchoolClass setSchoolClassId(String schoolClassId) {
        this.schoolClassId = schoolClassId;
        return this;
    }

    /**
     * 班级ID
     */
    public String getSchoolClassId() {
        return schoolClassId;
    }

    /**
     * 班级名称
     */
    public SchoolClass setSchoolClassName(String schoolClassName) {
        this.schoolClassName = schoolClassName;
        return this;
    }

    /**
     * 班级名称
     */
    public String getSchoolClassName() {
        return schoolClassName;
    }

    /**
     * 专业是否被删除
     */
    public SchoolClass setSchoolClassIsDeleted(boolean schoolClassIsDeleted) {
        this.schoolClassIsDeleted = schoolClassIsDeleted;
        return this;
    }

    /**
     * 专业是否被删除
     */
    public boolean getSchoolClassIsDeleted() {
        return schoolClassIsDeleted;
    }

    /**
     * 专业是否被禁用
     */
    public SchoolClass setSchoolClassIsForbidden(boolean schoolClassIsForbidden) {
        this.schoolClassIsForbidden = schoolClassIsForbidden;
        return this;
    }

    /**
     * 专业是否被禁用
     */
    public boolean getSchoolClassIsForbidden() {
        return schoolClassIsForbidden;
    }

    public SchoolClass setFaculty(Faculty schoolClassFacultyId) {
        this.faculty = schoolClassFacultyId;
        return this;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public SchoolClass setMajor(Major schoolClassMajorId) {
        this.major = schoolClassMajorId;
        return this;
    }

    public Major getMajor() {
        return major;
    }

    public SchoolClass setTeacher(Teacher schoolClassTeacherId) {
        this.teacher = schoolClassTeacherId;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "schoolClassId=" + schoolClassId + '\'' +
                "schoolClassName=" + schoolClassName + '\'' +
                "schoolClassIsDeleted=" + schoolClassIsDeleted + '\'' +
                "schoolClassIsForbidden=" + schoolClassIsForbidden + '\'' +
                "schoolClassFacultyId=" + faculty + '\'' +
                "schoolClassMajorId=" + major + '\'' +
                "schoolClassTeacherId=" + teacher + '\'' +
                '}';
    }
}
