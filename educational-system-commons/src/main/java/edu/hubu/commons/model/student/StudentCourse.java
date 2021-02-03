package edu.hubu.commons.model.student;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.admin.Term;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 学生课程
 */
@Entity
@Table(name = "student_course")
@ApiModel("学生课程")
public class StudentCourse implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public StudentCourse() {
        this.studentCourseId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 学生课程ID
     */
    @Id
    @Column(name = "student_course_id", nullable = false)
    private String studentCourseId;

    /**
     * 课程星期几
     */
    @Column(name = "student_course_week_day", nullable = false)
    @Range(min = 1, max = 7)
    private Long studentCourseWeekDay;

    /**
     * 课程周次，1为单周，2为双周，3为全部
     */
    @Column(name = "student_course_week_time", nullable = false)
    private Long studentCourseWeekTime;

    /**
     * 学生ID
     */
    @ManyToOne
    @JoinColumn(name = "student_course_student_id", nullable = false)
    private Student student;

    /**
     * 选课ID
     */
    @ManyToOne
    @JoinColumn(name = "student_course_student_select_course_id", nullable = false)
    private StudentSelectCourse studentSelectCourse;

    /**
     * 学期ID
     */
    @ManyToOne
    @JoinColumn(name = "student_course_term_id", nullable = false)
    private Term term;

    @OneToMany(mappedBy = "studentCourse")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentCourseTimeBlock> studentCourseTimeBlocks;

    /**
     * 学生课程ID
     */
    public StudentCourse setStudentCourseId(String studentCourseId) {
        this.studentCourseId = studentCourseId;
        return this;
    }

    /**
     * 学生课程ID
     */
    public String getStudentCourseId() {
        return studentCourseId;
    }

    /**
     * 课程星期几
     */
    public StudentCourse setStudentCourseWeekDay(Long studentCourseWeekDay) {
        this.studentCourseWeekDay = studentCourseWeekDay;
        return this;
    }

    /**
     * 课程星期几
     */
    public Long getStudentCourseWeekDay() {
        return studentCourseWeekDay;
    }

    /**
     * 课程周次，1为单周，2为双周，3为全部
     */
    public StudentCourse setStudentCourseWeekTime(Long studentCourseWeekTime) {
        this.studentCourseWeekTime = studentCourseWeekTime;
        return this;
    }

    /**
     * 课程周次，1为单周，2为双周，3为全部
     */
    public Long getStudentCourseWeekTime() {
        return studentCourseWeekTime;
    }

    /**
     * 学生ID
     */
    public StudentCourse setStudent(Student studentCourseStudentId) {
        this.student = studentCourseStudentId;
        return this;
    }

    /**
     * 学生ID
     */
    public Student getStudent() {
        return student;
    }

    /**
     * 选课ID
     */
    public StudentCourse setStudentSelectCourse(StudentSelectCourse studentCourseStudentSelectCourseId) {
        this.studentSelectCourse = studentCourseStudentSelectCourseId;
        return this;
    }

    /**
     * 选课ID
     */
    public StudentSelectCourse getStudentSelectCourse() {
        return studentSelectCourse;
    }

    /**
     * 学期ID
     */
    public StudentCourse setTerm(Term studentCourseTermId) {
        this.term = studentCourseTermId;
        return this;
    }

    /**
     * 学期ID
     */
    public Term getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "studentCourseId=" + studentCourseId + '\'' +
                "studentCourseWeekDay=" + studentCourseWeekDay + '\'' +
                "studentCourseWeekTime=" + studentCourseWeekTime + '\'' +
                "student=" + student + '\'' +
                "studentSelectCourse=" + studentSelectCourse + '\'' +
                "term=" + term + '\'' +
                '}';
    }
}
