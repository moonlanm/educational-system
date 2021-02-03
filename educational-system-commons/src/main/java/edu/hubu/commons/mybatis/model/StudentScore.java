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
public class StudentScore implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentScoreId;

    private String studentScoreScoreId;

    private String studentScoreStudentId;

    private Student student;

    private Score score;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getStudentScoreId() {
        return studentScoreId;
    }

    public void setStudentScoreId(String studentScoreId) {
        this.studentScoreId = studentScoreId;
    }
    public String getStudentScoreScoreId() {
        return studentScoreScoreId;
    }

    public void setStudentScoreScoreId(String studentScoreScoreId) {
        this.studentScoreScoreId = studentScoreScoreId;
    }
    public String getStudentScoreStudentId() {
        return studentScoreStudentId;
    }

    public void setStudentScoreStudentId(String studentScoreStudentId) {
        this.studentScoreStudentId = studentScoreStudentId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentScore{");
        sb.append("studentScoreId='").append(studentScoreId).append('\'');
        sb.append(", studentScoreScoreId='").append(studentScoreScoreId).append('\'');
        sb.append(", studentScoreStudentId='").append(studentScoreStudentId).append('\'');
        sb.append(", student=").append(student);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
