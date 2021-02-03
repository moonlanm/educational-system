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
public class Term implements Serializable {

    private static final long serialVersionUID = 1L;

    private String termId;

    private String termName;

    private List<StudentCourse> studentCourses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }
    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Term{");
        sb.append("termId='").append(termId).append('\'');
        sb.append(", termName='").append(termName).append('\'');
        sb.append(", studentCourses=").append(studentCourses);
        sb.append('}');
        return sb.toString();
    }
}
