package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.student.StudentCourseTimeBlock;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 学期
 */
@Entity
@Table(name = "time_block")
@ApiModel("一天分得的时间块")
public class TimeBlock implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public TimeBlock() {
        this.timeBlockId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 时间块ID
     */
    @Id
    @Column(name = "time_block_id", nullable = false)
    private String timeBlockId;

    /**
     * 时间名称
     */
    @Column(name = "term_name")
    private String termName;

    @OneToMany(mappedBy = "timeBlock")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentCourseTimeBlock> studentCourseTimeBlocks;

    /**
     * 时间块ID
     */
    public TimeBlock setTimeBlockId(String timeBlockId) {
        this.timeBlockId = timeBlockId;
        return this;
    }

    /**
     * 时间块ID
     */
    public String getTimeBlockId() {
        return timeBlockId;
    }

    /**
     * 时间名称
     */
    public TimeBlock setTermName(String termName) {
        this.termName = termName;
        return this;
    }

    /**
     * 时间名称
     */
    public String getTermName() {
        return termName;
    }

    @Override
    public String toString() {
        return "TimeBlock{" +
                "timeBlockId=" + timeBlockId + '\'' +
                "termName=" + termName + '\'' +
                '}';
    }
}
