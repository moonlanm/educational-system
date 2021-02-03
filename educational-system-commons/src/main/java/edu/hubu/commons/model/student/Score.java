package edu.hubu.commons.model.student;

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
 * 分数
 */
@Entity
@Table(name = "score")
@ApiModel("成绩")
public class Score implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Score() {
        this.scoreId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 分数ID
     */
    @Id
    @Column(name = "score_id", nullable = false)
    private String scoreId;

    /**
     * 平时分
     */
    @Column(name = "score_usual", nullable = false)
    private String scoreUsual = "0";

    /**
     * 期末分
     */
    @Column(name = "score_exam", nullable = false)
    private String scoreExam = "0";

    /**
     * 总分
     */
    @Column(name = "score_final", nullable = false)
    private String scoreFinal = String.valueOf(Integer.parseInt(scoreExam) + Integer.parseInt(scoreUsual));

    /**
     * 分数是否提交
     */
    @Column(name = "score_is_committed", nullable = false)
    private boolean scoreIsCommitted = false;

    /**
     * 分数是否被删除
     */
    @Column(name = "score_is_deleted", nullable = false)
    private boolean scoreIsDeleted = false;

    /**
     * 分数是否被禁用
     */
    @Column(name = "score_is_forbidden", nullable = false)
    private boolean scoreIsForbidden = false;

    /**
     * 学生课程ID
     */
    @ManyToOne
    @JoinColumn(name = "score_student_course_id")
    private Course course;

    @OneToMany(mappedBy = "score")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentScore> studentScores;

    /**
     * 分数ID
     */
    public Score setScoreId(String scoreId) {
        this.scoreId = scoreId;
        return this;
    }

    /**
     * 分数ID
     */
    public String getScoreId() {
        return scoreId;
    }

    /**
     * 平时分
     */
    public Score setScoreUsual(String scoreUsual) {
        this.scoreUsual = scoreUsual;
        return this;
    }

    /**
     * 平时分
     */
    public String getScoreUsual() {
        return scoreUsual;
    }

    /**
     * 期末分
     */
    public Score setScoreExam(String scoreExam) {
        this.scoreExam = scoreExam;
        return this;
    }

    /**
     * 期末分
     */
    public String getScoreExam() {
        return scoreExam;
    }

    /**
     * 总分
     */
    public Score setScoreFinal(String scoreFinal) {
        this.scoreFinal = scoreFinal;
        return this;
    }

    /**
     * 总分
     */
    public String getScoreFinal() {
        return scoreFinal;
    }

    /**
     * 分数是否提交
     */
    public Score setScoreIsCommitted(boolean scoreIsCommitted) {
        this.scoreIsCommitted = scoreIsCommitted;
        return this;
    }

    /**
     * 分数是否提交
     */
    public boolean getScoreIsCommitted() {
        return scoreIsCommitted;
    }

    /**
     * 分数是否被删除
     */
    public Score setScoreIsDeleted(boolean scoreIsDeleted) {
        this.scoreIsDeleted = scoreIsDeleted;
        return this;
    }

    /**
     * 分数是否被删除
     */
    public boolean getScoreIsDeleted() {
        return scoreIsDeleted;
    }

    /**
     * 分数是否被禁用
     */
    public Score setScoreIsForbidden(boolean scoreIsForbidden) {
        this.scoreIsForbidden = scoreIsForbidden;
        return this;
    }

    /**
     * 分数是否被禁用
     */
    public boolean getScoreIsForbidden() {
        return scoreIsForbidden;
    }

    /**
     * 学生课程ID
     */
    public Score setCourse(Course scoreStudentCourseId) {
        this.course = scoreStudentCourseId;
        return this;
    }

    /**
     * 学生课程ID
     */
    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId + '\'' +
                "scoreUsual=" + scoreUsual + '\'' +
                "scoreExam=" + scoreExam + '\'' +
                "scoreFinal=" + scoreFinal + '\'' +
                "scoreIsCommitted=" + scoreIsCommitted + '\'' +
                "scoreIsDeleted=" + scoreIsDeleted + '\'' +
                "scoreIsForbidden=" + scoreIsForbidden + '\'' +
                "course=" + course + '\'' +
                '}';
    }
}
