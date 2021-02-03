package edu.hubu.commons.mybatis.model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author moonlan
 * @since 2021-02-01
 */
public class StudentCourseTimeBlock implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentCourseTimeBlockId;

    private String studentCourseTimeBlockStudentCourseId;

    private String studentCourseTimeBlockTimeBlockId;

    private StudentCourse studentCourse;

    private TimeBlock timeBlock;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StudentCourse getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentCourse studentCourse) {
        this.studentCourse = studentCourse;
    }

    public TimeBlock getTimeBlock() {
        return timeBlock;
    }

    public void setTimeBlock(TimeBlock timeBlock) {
        this.timeBlock = timeBlock;
    }

    public String getStudentCourseTimeBlockId() {
        return studentCourseTimeBlockId;
    }

    public void setStudentCourseTimeBlockId(String studentCourseTimeBlockId) {
        this.studentCourseTimeBlockId = studentCourseTimeBlockId;
    }
    public String getStudentCourseTimeBlockStudentCourseId() {
        return studentCourseTimeBlockStudentCourseId;
    }

    public void setStudentCourseTimeBlockStudentCourseId(String studentCourseTimeBlockStudentCourseId) {
        this.studentCourseTimeBlockStudentCourseId = studentCourseTimeBlockStudentCourseId;
    }
    public String getStudentCourseTimeBlockTimeBlockId() {
        return studentCourseTimeBlockTimeBlockId;
    }

    public void setStudentCourseTimeBlockTimeBlockId(String studentCourseTimeBlockTimeBlockId) {
        this.studentCourseTimeBlockTimeBlockId = studentCourseTimeBlockTimeBlockId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentCourseTimeBlock{");
        sb.append("studentCourseTimeBlockId='").append(studentCourseTimeBlockId).append('\'');
        sb.append(", studentCourseTimeBlockStudentCourseId='").append(studentCourseTimeBlockStudentCourseId).append('\'');
        sb.append(", studentCourseTimeBlockTimeBlockId='").append(studentCourseTimeBlockTimeBlockId).append('\'');
        sb.append(", studentCourse=").append(studentCourse);
        sb.append(", timeBlock=").append(timeBlock);
        sb.append('}');
        return sb.toString();
    }
}
