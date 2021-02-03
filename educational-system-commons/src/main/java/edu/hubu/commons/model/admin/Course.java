package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.student.Score;
import edu.hubu.commons.model.teacher.TeacherSelectCourse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 课程
 */
@Entity
@Table(name = "course")
@ApiModel("课程")
public class Course implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Course() {
        this.courseId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 课程ID
     */
    @Id
    @Column(name = "course_id", nullable = false)
    private String courseId;

    /**
     * 课程名称
     */
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /**
     * 课程是否被删除
     */
    @Column(name = "course_is_deleted", nullable = false)
    private boolean courseIsDeleted = false;

    /**
     * 课程是否被禁用
     */
    @Column(name = "course_is_forbidden", nullable = false)
    private boolean courseIsForbidden = false;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<Score> scores;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<TeacherSelectCourse> teacherSelectCourses;

    /**
     * 课程ID
     */
    public Course setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    /**
     * 课程ID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 课程名称
     */
    public Course setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    /**
     * 课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 课程是否被删除
     */
    public Course setCourseIsDeleted(boolean courseIsDeleted) {
        this.courseIsDeleted = courseIsDeleted;
        return this;
    }

    /**
     * 课程是否被删除
     */
    public boolean getCourseIsDeleted() {
        return courseIsDeleted;
    }

    /**
     * 课程是否被禁用
     */
    public Course setCourseIsForbidden(boolean courseIsForbidden) {
        this.courseIsForbidden = courseIsForbidden;
        return this;
    }

    /**
     * 课程是否被禁用
     */
    public boolean getCourseIsForbidden() {
        return courseIsForbidden;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId + '\'' +
                "courseName=" + courseName + '\'' +
                "courseIsDeleted=" + courseIsDeleted + '\'' +
                "courseIsForbidden=" + courseIsForbidden + '\'' +
                '}';
    }
}
