package edu.hubu.commons.model.teacher;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.student.StudentSelectCourse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 老师课程
 */
@Entity
@Table(name = "teacher_course")
@ApiModel("老师选课")
public class TeacherCourse implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public TeacherCourse() {
        this.teacherCourseId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 老师课程ID
     */
    @Id
    @Column(name = "teacher_course_id")
    private String teacherCourseId;

    /**
     * 老师ID
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    /**
     * 学分
     */
    @Column(name = "teacher_course_credit", nullable = false)
    private String teacherCourseCredit;

    /**
     * 学时
     */
    @Column(name = "teacher_course_hour", nullable = false)
    private Long teacherCourseHour;

    /**
     * 选课ID
     */
    @ManyToOne
    @JoinColumn(name = "teacher_select_course_id", nullable = false)
    private TeacherSelectCourse teacherSelectCourse;

    @OneToMany(mappedBy = "teacherCourse")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentSelectCourse> studentSelectCourses;

    /**
     * 老师ID
     */
    public TeacherCourse setTeacher(Teacher teacherId) {
        this.teacher = teacherId;
        return this;
    }

    /**
     * 老师ID
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * 老师课程ID
     */
    public TeacherCourse setTeacherCourseId(String teacherCourseId) {
        this.teacherCourseId = teacherCourseId;
        return this;
    }

    /**
     * 老师课程ID
     */
    public String getTeacherCourseId() {
        return teacherCourseId;
    }

    /**
     * 学分
     */
    public TeacherCourse setTeacherCourseCredit(String teacherCourseCredit) {
        this.teacherCourseCredit = teacherCourseCredit;
        return this;
    }

    /**
     * 学分
     */
    public String getTeacherCourseCredit() {
        return teacherCourseCredit;
    }

    /**
     * 学时
     */
    public TeacherCourse setTeacherCourseHour(Long teacherCourseHour) {
        this.teacherCourseHour = teacherCourseHour;
        return this;
    }

    /**
     * 学时
     */
    public Long getTeacherCourseHour() {
        return teacherCourseHour;
    }

    /**
     * 选课ID
     */
    public TeacherCourse setTeacherSelectCourse(TeacherSelectCourse teacherSelectCourseId) {
        this.teacherSelectCourse = teacherSelectCourseId;
        return this;
    }

    /**
     * 选课ID
     */
    public TeacherSelectCourse getTeacherSelectCourse() {
        return teacherSelectCourse;
    }

    @Override
    public String toString() {
        return "TeacherCourse{" +
                "teacherId=" + teacher + '\'' +
                "teacherCourseId=" + teacherCourseId + '\'' +
                "teacherCourseCredit=" + teacherCourseCredit + '\'' +
                "teacherCourseHour=" + teacherCourseHour + '\'' +
                "teacherSelectCourse=" + teacherSelectCourse + '\'' +
                '}';
    }
}
