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
public class StudentSelectCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentSelectCourseId;

    private Long studentSelectCourseCurrentStudentNum;

    private Long studentSelectCourseMaxStudentNum;

    private String studentSelectCourseStudentId;

    private String studentSelectCourseTeacherCourseId;

    private TeacherCourse teacherCourse;

    private Student student;

    private List<StudentCourse> studentCourses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TeacherCourse getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(TeacherCourse teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public String getStudentSelectCourseId() {
        return studentSelectCourseId;
    }

    public void setStudentSelectCourseId(String studentSelectCourseId) {
        this.studentSelectCourseId = studentSelectCourseId;
    }
    public Long getStudentSelectCourseCurrentStudentNum() {
        return studentSelectCourseCurrentStudentNum;
    }

    public void setStudentSelectCourseCurrentStudentNum(Long studentSelectCourseCurrentStudentNum) {
        this.studentSelectCourseCurrentStudentNum = studentSelectCourseCurrentStudentNum;
    }
    public Long getStudentSelectCourseMaxStudentNum() {
        return studentSelectCourseMaxStudentNum;
    }

    public void setStudentSelectCourseMaxStudentNum(Long studentSelectCourseMaxStudentNum) {
        this.studentSelectCourseMaxStudentNum = studentSelectCourseMaxStudentNum;
    }
    public String getStudentSelectCourseStudentId() {
        return studentSelectCourseStudentId;
    }

    public void setStudentSelectCourseStudentId(String studentSelectCourseStudentId) {
        this.studentSelectCourseStudentId = studentSelectCourseStudentId;
    }
    public String getStudentSelectCourseTeacherCourseId() {
        return studentSelectCourseTeacherCourseId;
    }

    public void setStudentSelectCourseTeacherCourseId(String studentSelectCourseTeacherCourseId) {
        this.studentSelectCourseTeacherCourseId = studentSelectCourseTeacherCourseId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentSelectCourse{");
        sb.append("studentSelectCourseId='").append(studentSelectCourseId).append('\'');
        sb.append(", studentSelectCourseCurrentStudentNum=").append(studentSelectCourseCurrentStudentNum);
        sb.append(", studentSelectCourseMaxStudentNum=").append(studentSelectCourseMaxStudentNum);
        sb.append(", studentSelectCourseStudentId='").append(studentSelectCourseStudentId).append('\'');
        sb.append(", studentSelectCourseTeacherCourseId='").append(studentSelectCourseTeacherCourseId).append('\'');
        sb.append(", teacherCourse=").append(teacherCourse);
        sb.append(", student=").append(student);
        sb.append(", studentCourses=").append(studentCourses);
        sb.append('}');
        return sb.toString();
    }
}
