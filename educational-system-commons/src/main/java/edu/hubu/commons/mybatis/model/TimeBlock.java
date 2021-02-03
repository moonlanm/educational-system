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
public class TimeBlock implements Serializable {

    private static final long serialVersionUID = 1L;

    private String timeBlockId;

    private String termName;

    private List<StudentCourseTimeBlock> studentCourseTimeBlocks;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<StudentCourseTimeBlock> getStudentCourseTimeBlocks() {
        return studentCourseTimeBlocks;
    }

    public void setStudentCourseTimeBlocks(List<StudentCourseTimeBlock> studentCourseTimeBlocks) {
        this.studentCourseTimeBlocks = studentCourseTimeBlocks;
    }

    public String getTimeBlockId() {
        return timeBlockId;
    }

    public void setTimeBlockId(String timeBlockId) {
        this.timeBlockId = timeBlockId;
    }
    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TimeBlock{");
        sb.append("timeBlockId='").append(timeBlockId).append('\'');
        sb.append(", termName='").append(termName).append('\'');
        sb.append(", studentCourseTimeBlocks=").append(studentCourseTimeBlocks);
        sb.append('}');
        return sb.toString();
    }
}
