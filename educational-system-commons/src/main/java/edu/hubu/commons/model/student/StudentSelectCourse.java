package edu.hubu.commons.model.student;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.teacher.TeacherCourse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 学生选课
 */
@Entity
@Table(name = "student_select_course")
@ApiModel("学生选课")
public class StudentSelectCourse implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public StudentSelectCourse() {
        this.studentSelectCourseId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 学生选课ID
     */
    @Id
    @Column(name = "student_select_course_id", nullable = false)
    private String studentSelectCourseId;

    /**
     * 学生选课最大人数
     */
    @Column(name = "student_select_course_max_student_num", nullable = false)
    private Long studentSelectCourseMaxStudentNum;

    /**
     * 当前选课人数
     */
    @Column(name = "student_select_course_current_student_num", nullable = false)
    private Long studentSelectCourseCurrentStudentNum;

    @ManyToOne
    @JoinColumn(name = "student_select_course_teacher_course_id")
    private TeacherCourse teacherCourse;

    /**
     * 学生ID
     */
    @ManyToOne
    @JoinColumn(name = "student_select_course_student_id", nullable = false)
    private Student student;

    @OneToMany(mappedBy = "studentSelectCourse")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentCourse> studentCourses;

    /**
     * 学生选课ID
     */
    public StudentSelectCourse setStudentSelectCourseId(String studentSelectCourseId) {
        this.studentSelectCourseId = studentSelectCourseId;
        return this;
    }

    /**
     * 学生选课ID
     */
    public String getStudentSelectCourseId() {
        return studentSelectCourseId;
    }

    /**
     * 学生选课最大人数
     */
    public StudentSelectCourse setStudentSelectCourseMaxStudentNum(Long studentSelectCourseMaxStudentNum) {
        this.studentSelectCourseMaxStudentNum = studentSelectCourseMaxStudentNum;
        return this;
    }

    /**
     * 学生选课最大人数
     */
    public Long getStudentSelectCourseMaxStudentNum() {
        return studentSelectCourseMaxStudentNum;
    }

    /**
     * 当前选课人数
     */
    public StudentSelectCourse setStudentSelectCourseCurrentStudentNum(Long studentSelectCourseCurrentStudentNum) {
        this.studentSelectCourseCurrentStudentNum = studentSelectCourseCurrentStudentNum;
        return this;
    }

    /**
     * 当前选课人数
     */
    public Long getStudentSelectCourseCurrentStudentNum() {
        return studentSelectCourseCurrentStudentNum;
    }

    public StudentSelectCourse setTeacherCourse(TeacherCourse studentSelectCourseTeacherCourseId) {
        this.teacherCourse = studentSelectCourseTeacherCourseId;
        return this;
    }

    public TeacherCourse getTeacherCourse() {
        return teacherCourse;
    }

    /**
     * 学生ID
     */
    public StudentSelectCourse setStudent(Student studentSelectCourseStudentId) {
        this.student = studentSelectCourseStudentId;
        return this;
    }

    /**
     * 学生ID
     */
    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "StudentSelectCourse{" +
                "studentSelectCourseId=" + studentSelectCourseId + '\'' +
                "studentSelectCourseMaxStudentNum=" + studentSelectCourseMaxStudentNum + '\'' +
                "studentSelectCourseCurrentStudentNum=" + studentSelectCourseCurrentStudentNum + '\'' +
                "teacherCourse=" + teacherCourse + '\'' +
                "student=" + student + '\'' +
                '}';
    }
}
