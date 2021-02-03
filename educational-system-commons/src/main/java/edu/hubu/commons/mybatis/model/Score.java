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
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    private String scoreId;

    private String scoreExam;

    private String scoreFinal;

    private Boolean scoreIsCommitted;

    private Boolean scoreIsDeleted;

    private Boolean scoreIsForbidden;

    private String scoreUsual;

    private String scoreStudentCourseId;

    private Course course;

    private List<StudentScore> studentScores;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<StudentScore> getStudentScores() {
        return studentScores;
    }

    public void setStudentScores(List<StudentScore> studentScores) {
        this.studentScores = studentScores;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }
    public String getScoreExam() {
        return scoreExam;
    }

    public void setScoreExam(String scoreExam) {
        this.scoreExam = scoreExam;
    }
    public String getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(String scoreFinal) {
        this.scoreFinal = scoreFinal;
    }
    public Boolean getScoreIsCommitted() {
        return scoreIsCommitted;
    }

    public void setScoreIsCommitted(Boolean scoreIsCommitted) {
        this.scoreIsCommitted = scoreIsCommitted;
    }
    public Boolean getScoreIsDeleted() {
        return scoreIsDeleted;
    }

    public void setScoreIsDeleted(Boolean scoreIsDeleted) {
        this.scoreIsDeleted = scoreIsDeleted;
    }
    public Boolean getScoreIsForbidden() {
        return scoreIsForbidden;
    }

    public void setScoreIsForbidden(Boolean scoreIsForbidden) {
        this.scoreIsForbidden = scoreIsForbidden;
    }
    public String getScoreUsual() {
        return scoreUsual;
    }

    public void setScoreUsual(String scoreUsual) {
        this.scoreUsual = scoreUsual;
    }
    public String getScoreStudentCourseId() {
        return scoreStudentCourseId;
    }

    public void setScoreStudentCourseId(String scoreStudentCourseId) {
        this.scoreStudentCourseId = scoreStudentCourseId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Score{");
        sb.append("scoreId='").append(scoreId).append('\'');
        sb.append(", scoreExam='").append(scoreExam).append('\'');
        sb.append(", scoreFinal='").append(scoreFinal).append('\'');
        sb.append(", scoreIsCommitted=").append(scoreIsCommitted);
        sb.append(", scoreIsDeleted=").append(scoreIsDeleted);
        sb.append(", scoreIsForbidden=").append(scoreIsForbidden);
        sb.append(", scoreUsual='").append(scoreUsual).append('\'');
        sb.append(", scoreStudentCourseId='").append(scoreStudentCourseId).append('\'');
        sb.append(", course=").append(course);
        sb.append(", studentScores=").append(studentScores);
        sb.append('}');
        return sb.toString();
    }
}
