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
public class TeacherSelectCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String teacherSelectCourseId;

    private String teacherSelectCourseCourseId;

    private String teacherSelectCourseTeacherId;

    private Course course;

    private Teacher teacher;

    private List<TeacherCourse> teacherCourses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<TeacherCourse> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(List<TeacherCourse> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    public String getTeacherSelectCourseId() {
        return teacherSelectCourseId;
    }

    public void setTeacherSelectCourseId(String teacherSelectCourseId) {
        this.teacherSelectCourseId = teacherSelectCourseId;
    }
    public String getTeacherSelectCourseCourseId() {
        return teacherSelectCourseCourseId;
    }

    public void setTeacherSelectCourseCourseId(String teacherSelectCourseCourseId) {
        this.teacherSelectCourseCourseId = teacherSelectCourseCourseId;
    }
    public String getTeacherSelectCourseTeacherId() {
        return teacherSelectCourseTeacherId;
    }

    public void setTeacherSelectCourseTeacherId(String teacherSelectCourseTeacherId) {
        this.teacherSelectCourseTeacherId = teacherSelectCourseTeacherId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TeacherSelectCourse{");
        sb.append("teacherSelectCourseId='").append(teacherSelectCourseId).append('\'');
        sb.append(", teacherSelectCourseCourseId='").append(teacherSelectCourseCourseId).append('\'');
        sb.append(", teacherSelectCourseTeacherId='").append(teacherSelectCourseTeacherId).append('\'');
        sb.append(", course=").append(course);
        sb.append(", teacher=").append(teacher);
        sb.append(", teacherCourses=").append(teacherCourses);
        sb.append('}');
        return sb.toString();
    }
}
