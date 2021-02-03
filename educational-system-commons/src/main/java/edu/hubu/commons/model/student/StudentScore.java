package edu.hubu.commons.model.student;

import cn.hutool.core.util.IdUtil;
import edu.hubu.commons.model.BaseModel;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 学生成绩
 */
@Entity
@Table(name = "student_score")
@ApiModel("学生成绩")
public class StudentScore implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public StudentScore() {
        this.studentScoreId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 学生成绩ID
     */
    @Id
    @Column(name = "student_score_id", nullable = false)
    private String studentScoreId;

    /**
     * 学生ID
     */
    @ManyToOne
    @JoinColumn(name = "student_score_student_id", nullable = false)
    private Student student;

    /**
     * 成绩ID
     */
    @ManyToOne
    @JoinColumn(name = "student_score_score_id", nullable = false)
    private Score score;

    /**
     * 学生成绩ID
     */
    public StudentScore setStudentScoreId(String studentScoreId) {
        this.studentScoreId = studentScoreId;
        return this;
    }

    /**
     * 学生成绩ID
     */
    public String getStudentScoreId() {
        return studentScoreId;
    }

    /**
     * 学生ID
     */
    public StudentScore setStudent(Student studentScoreStudentId) {
        this.student = studentScoreStudentId;
        return this;
    }

    /**
     * 学生ID
     */
    public Student getStudent() {
        return student;
    }

    /**
     * 成绩ID
     */
    public StudentScore setScore(Score studentScoreScoreId) {
        this.score = studentScoreScoreId;
        return this;
    }

    /**
     * 成绩ID
     */
    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "studentScoreId=" + studentScoreId + '\'' +
                "student=" + student + '\'' +
                "score=" + score + '\'' +
                '}';
    }
}
