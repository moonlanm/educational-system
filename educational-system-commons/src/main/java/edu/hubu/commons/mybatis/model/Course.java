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
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseId;

    private Boolean courseIsDeleted;

    private Boolean courseIsForbidden;

    private String courseName;

    private List<Score> scores;

    private List<TeacherSelectCourse> teacherSelectCourses;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public List<TeacherSelectCourse> getTeacherSelectCourses() {
        return teacherSelectCourses;
    }

    public void setTeacherSelectCourses(List<TeacherSelectCourse> teacherSelectCourses) {
        this.teacherSelectCourses = teacherSelectCourses;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public Boolean getCourseIsDeleted() {
        return courseIsDeleted;
    }

    public void setCourseIsDeleted(Boolean courseIsDeleted) {
        this.courseIsDeleted = courseIsDeleted;
    }
    public Boolean getCourseIsForbidden() {
        return courseIsForbidden;
    }

    public void setCourseIsForbidden(Boolean courseIsForbidden) {
        this.courseIsForbidden = courseIsForbidden;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Course{");
        sb.append("courseId='").append(courseId).append('\'');
        sb.append(", courseIsDeleted=").append(courseIsDeleted);
        sb.append(", courseIsForbidden=").append(courseIsForbidden);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", scores=").append(scores);
        sb.append(", teacherSelectCourses=").append(teacherSelectCourses);
        sb.append('}');
        return sb.toString();
    }
}
