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
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentCourseId;

    private Long studentCourseWeekDay;

    private Long studentCourseWeekTime;

    private String studentCourseStudentId;

    private String studentCourseStudentSelectCourseId;

    private String studentCourseTermId;

    private Student student;

    private StudentSelectCourse studentSelectCourse;

    private Term term;

    private List<StudentCourseTimeBlock> studentCourseTimeBlocks;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentSelectCourse getStudentSelectCourse() {
        return studentSelectCourse;
    }

    public void setStudentSelectCourse(StudentSelectCourse studentSelectCourse) {
        this.studentSelectCourse = studentSelectCourse;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public List<StudentCourseTimeBlock> getStudentCourseTimeBlocks() {
        return studentCourseTimeBlocks;
    }

    public void setStudentCourseTimeBlocks(List<StudentCourseTimeBlock> studentCourseTimeBlocks) {
        this.studentCourseTimeBlocks = studentCourseTimeBlocks;
    }

    public String getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(String studentCourseId) {
        this.studentCourseId = studentCourseId;
    }
    public Long getStudentCourseWeekDay() {
        return studentCourseWeekDay;
    }

    public void setStudentCourseWeekDay(Long studentCourseWeekDay) {
        this.studentCourseWeekDay = studentCourseWeekDay;
    }
    public Long getStudentCourseWeekTime() {
        return studentCourseWeekTime;
    }

    public void setStudentCourseWeekTime(Long studentCourseWeekTime) {
        this.studentCourseWeekTime = studentCourseWeekTime;
    }
    public String getStudentCourseStudentId() {
        return studentCourseStudentId;
    }

    public void setStudentCourseStudentId(String studentCourseStudentId) {
        this.studentCourseStudentId = studentCourseStudentId;
    }
    public String getStudentCourseStudentSelectCourseId() {
        return studentCourseStudentSelectCourseId;
    }

    public void setStudentCourseStudentSelectCourseId(String studentCourseStudentSelectCourseId) {
        this.studentCourseStudentSelectCourseId = studentCourseStudentSelectCourseId;
    }
    public String getStudentCourseTermId() {
        return studentCourseTermId;
    }

    public void setStudentCourseTermId(String studentCourseTermId) {
        this.studentCourseTermId = studentCourseTermId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentCourse{");
        sb.append("studentCourseId='").append(studentCourseId).append('\'');
        sb.append(", studentCourseWeekDay=").append(studentCourseWeekDay);
        sb.append(", studentCourseWeekTime=").append(studentCourseWeekTime);
        sb.append(", studentCourseStudentId='").append(studentCourseStudentId).append('\'');
        sb.append(", studentCourseStudentSelectCourseId='").append(studentCourseStudentSelectCourseId).append('\'');
        sb.append(", studentCourseTermId='").append(studentCourseTermId).append('\'');
        sb.append(", student=").append(student);
        sb.append(", studentSelectCourse=").append(studentSelectCourse);
        sb.append(", term=").append(term);
        sb.append(", studentCourseTimeBlocks=").append(studentCourseTimeBlocks);
        sb.append('}');
        return sb.toString();
    }
}
