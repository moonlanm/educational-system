package edu.hubu.commons.mybatis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

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
public class TeacherCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String teacherCourseId;

    private String teacherCourseCredit;

    private Long teacherCourseHour;

    private String teacherId;

    private String teacherSelectCourseId;

    private TeacherSelectCourse teacherSelectCourse;

    private List<StudentSelectCourse> studentSelectCourses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TeacherSelectCourse getTeacherSelectCourse() {
        return teacherSelectCourse;
    }

    public void setTeacherSelectCourse(TeacherSelectCourse teacherSelectCourse) {
        this.teacherSelectCourse = teacherSelectCourse;
    }

    public List<StudentSelectCourse> getStudentSelectCourses() {
        return studentSelectCourses;
    }

    public void setStudentSelectCourses(List<StudentSelectCourse> studentSelectCourses) {
        this.studentSelectCourses = studentSelectCourses;
    }

    public String getTeacherCourseId() {
        return teacherCourseId;
    }

    public void setTeacherCourseId(String teacherCourseId) {
        this.teacherCourseId = teacherCourseId;
    }
    public String getTeacherCourseCredit() {
        return teacherCourseCredit;
    }

    public void setTeacherCourseCredit(String teacherCourseCredit) {
        this.teacherCourseCredit = teacherCourseCredit;
    }
    public Long getTeacherCourseHour() {
        return teacherCourseHour;
    }

    public void setTeacherCourseHour(Long teacherCourseHour) {
        this.teacherCourseHour = teacherCourseHour;
    }
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeacherSelectCourseId() {
        return teacherSelectCourseId;
    }

    public void setTeacherSelectCourseId(String teacherSelectCourseId) {
        this.teacherSelectCourseId = teacherSelectCourseId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TeacherCourse{");
        sb.append("teacherCourseId='").append(teacherCourseId).append('\'');
        sb.append(", teacherCourseCredit='").append(teacherCourseCredit).append('\'');
        sb.append(", teacherCourseHour=").append(teacherCourseHour);
        sb.append(", teacherId='").append(teacherId).append('\'');
        sb.append(", teacherSelectCourseId='").append(teacherSelectCourseId).append('\'');
        sb.append(", teacherSelectCourse=").append(teacherSelectCourse);
        sb.append(", studentSelectCourses=").append(studentSelectCourses);
        sb.append('}');
        return sb.toString();
    }
}
