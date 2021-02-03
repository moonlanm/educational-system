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
 * 专业
 */
@Entity
@Table(name = "major")
@ApiModel("专业")
public class Major implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Major() {
        this.majorId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 专业ID
     */
    @Id
    @Column(name = "major_id", nullable = false)
    private String majorId;

    /**
     * 专业名称
     */
    @Column(name = "major_name", nullable = false)
    private String majorName;

    /**
     * 专业是否被删除
     */
    @Column(name = "major_is_deleted", nullable = false)
    private boolean majorIsDeleted = false;

    /**
     * 专业是否被禁用
     */
    @Column(name = "major_is_forbidden", nullable = false)
    private boolean majorIsForbidden = false;

    @ManyToOne
    @JoinColumn(name = "major_faculty_id", nullable = false)
    private Faculty faculty;

    @OneToMany(mappedBy = "major")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Student> students;

    @OneToMany(mappedBy = "major")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Teacher> teachers;

    /**
     * 专业ID
     */
    public Major setMajorId(String majorId) {
        this.majorId = majorId;
        return this;
    }

    /**
     * 专业ID
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * 专业名称
     */
    public Major setMajorName(String majorName) {
        this.majorName = majorName;
        return this;
    }

    /**
     * 专业名称
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 专业是否被删除
     */
    public Major setMajorIsDeleted(boolean majorIsDeleted) {
        this.majorIsDeleted = majorIsDeleted;
        return this;
    }

    /**
     * 专业是否被删除
     */
    public boolean getMajorIsDeleted() {
        return majorIsDeleted;
    }

    /**
     * 专业是否被禁用
     */
    public Major setMajorIsForbidden(boolean majorIsForbidden) {
        this.majorIsForbidden = majorIsForbidden;
        return this;
    }

    /**
     * 专业是否被禁用
     */
    public boolean getMajorIsForbidden() {
        return majorIsForbidden;
    }

    public Major setFaculty(Faculty majorFacultyId) {
        this.faculty = majorFacultyId;
        return this;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId + '\'' +
                "majorName=" + majorName + '\'' +
                "majorIsDeleted=" + majorIsDeleted + '\'' +
                "majorIsForbidden=" + majorIsForbidden + '\'' +
                "faculty=" + faculty + '\'' +
                '}';
    }
}
