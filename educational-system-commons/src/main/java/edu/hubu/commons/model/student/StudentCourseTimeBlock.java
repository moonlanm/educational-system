package edu.hubu.commons.model.student;

import cn.hutool.core.util.IdUtil;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.admin.TimeBlock;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 学生课程时间段
 */
@Entity
@Table(name = "student_course_time_block")
@ApiModel("学生课程时间表")
public class StudentCourseTimeBlock implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public StudentCourseTimeBlock() {
        this.studentCourseTimeBlockId = IdUtil.simpleUUID().substring(0, 6);
    }

    @Id
    @Column(name = "student_course_time_block_id", nullable = false)
    private String studentCourseTimeBlockId;

    @ManyToOne
    @JoinColumn(name = "student_course_time_block_student_course_id", nullable = false)
    private StudentCourse studentCourse;

    @ManyToOne
    @JoinColumn(name = "student_course_time_block_time_block_id", nullable = false)
    private TimeBlock timeBlock;

    public StudentCourseTimeBlock setStudentCourseTimeBlockId(String studentCourseTimeBlockId) {
        this.studentCourseTimeBlockId = studentCourseTimeBlockId;
        return this;
    }

    public String getStudentCourseTimeBlockId() {
        return studentCourseTimeBlockId;
    }

    public StudentCourseTimeBlock setStudentCourse(StudentCourse studentCourseTimeBlockStudentCourseId) {
        this.studentCourse = studentCourseTimeBlockStudentCourseId;
        return this;
    }

    public StudentCourse getStudentCourse() {
        return studentCourse;
    }

    public StudentCourseTimeBlock setTimeBlock(TimeBlock studentCourseTimeBlockTimeBlockId) {
        this.timeBlock = studentCourseTimeBlockTimeBlockId;
        return this;
    }

    public TimeBlock getTimeBlock() {
        return timeBlock;
    }

    @Override
    public String toString() {
        return "StudentCourseTimeBlock{" +
                "studentCourseTimeBlockId=" + studentCourseTimeBlockId + '\'' +
                "studentCourse=" + studentCourse + '\'' +
                "timeBlock=" + timeBlock + '\'' +
                '}';
    }
}
