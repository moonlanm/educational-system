package edu.hubu.commons.model.teacher;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.admin.Course;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 老师选课
 */
@Entity
@Table(name = "teacher_select_course")
@ApiModel("老师选课")
public class TeacherSelectCourse implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public TeacherSelectCourse() {
        this.teacherSelectCourseId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 课程ID
     */
    @ManyToOne
    @JoinColumn(name = "teacher_select_course_course_id", nullable = false)
    private Course course;

    /**
     * 老师选课ID
     */
    @Id
    @Column(name = "teacher_select_course_id")
    private String teacherSelectCourseId;

    /**
     * 老师ID
     */
    @ManyToOne
    @JoinColumn(name = "teacher_select_course_teacher_id", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "teacherSelectCourse")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<TeacherCourse> teacherCourses;

    /**
     * 课程ID
     */
    public TeacherSelectCourse setCourse(Course teacherSelectCourseCourseId) {
        this.course = teacherSelectCourseCourseId;
        return this;
    }

    /**
     * 课程ID
     */
    public Course getCourse() {
        return course;
    }

    /**
     * 老师选课ID
     */
    public TeacherSelectCourse setTeacherSelectCourseId(String teacherSelectCourseId) {
        this.teacherSelectCourseId = teacherSelectCourseId;
        return this;
    }

    /**
     * 老师选课ID
     */
    public String getTeacherSelectCourseId() {
        return teacherSelectCourseId;
    }

    /**
     * 老师ID
     */
    public TeacherSelectCourse setTeacher(Teacher teacherSelectCourseTeacherId) {
        this.teacher = teacherSelectCourseTeacherId;
        return this;
    }

    /**
     * 老师ID
     */
    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "TeacherSelectCourse{" +
                "course=" + course + '\'' +
                "teacherSelectCourseId=" + teacherSelectCourseId + '\'' +
                "teacher=" + teacher + '\'' +
                '}';
    }
}
