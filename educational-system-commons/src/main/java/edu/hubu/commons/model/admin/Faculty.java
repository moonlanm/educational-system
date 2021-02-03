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
 * 学院
 */
@Entity
@Table(name = "faculty")
@ApiModel("学院")
public class Faculty implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Faculty() {
        this.facultyId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 学院ID
     */
    @Id
    @Column(name = "faculty_id", nullable = false)
    private String facultyId;

    /**
     * 学院名称
     */
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    /**
     * 学院是否被删除
     */
    @Column(name = "faculty_is_deleted", nullable = false)
    private boolean facultyIsDeleted = false;

    /**
     * 学院是否被禁用
     */
    @Column(name = "faculty_is_forbidden", nullable = false)
    private boolean facultyIsForbidden = false;

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Major> majors;

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Student> students;

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Teacher> teachers;

    /**
     * 学院ID
     */
    public Faculty setFacultyId(String facultyId) {
        this.facultyId = facultyId;
        return this;
    }

    /**
     * 学院ID
     */
    public String getFacultyId() {
        return facultyId;
    }

    /**
     * 学院名称
     */
    public Faculty setFacultyName(String facultyName) {
        this.facultyName = facultyName;
        return this;
    }

    /**
     * 学院名称
     */
    public String getFacultyName() {
        return facultyName;
    }

    /**
     * 学院是否被删除
     */
    public Faculty setFacultyIsDeleted(boolean facultyIsDeleted) {
        this.facultyIsDeleted = facultyIsDeleted;
        return this;
    }

    /**
     * 学院是否被删除
     */
    public boolean getFacultyIsDeleted() {
        return facultyIsDeleted;
    }

    /**
     * 学院是否被禁用
     */
    public Faculty setFacultyIsForbidden(boolean facultyIsForbidden) {
        this.facultyIsForbidden = facultyIsForbidden;
        return this;
    }

    /**
     * 学院是否被禁用
     */
    public boolean getFacultyIsForbidden() {
        return facultyIsForbidden;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId + '\'' +
                "facultyName=" + facultyName + '\'' +
                "facultyIsDeleted=" + facultyIsDeleted + '\'' +
                "facultyIsForbidden=" + facultyIsForbidden + '\'' +
                '}';
    }
}
