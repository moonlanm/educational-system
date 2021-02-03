package edu.hubu.commons.model.admin;

import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hubu.commons.model.BaseModel;
import edu.hubu.commons.model.student.StudentCourse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 学期
 */
@Entity
@Table(name = "term")
@ApiModel("学期")
public class Term implements Serializable, BaseModel {

    private static final long serialVersionUID = 1L;

    public Term() {
        this.termId = IdUtil.simpleUUID().substring(0, 6);
    }

    /**
     * 学期ID
     */
    @Id
    @Column(name = "term_id", nullable = false)
    private String termId;

    /**
     * 学期名称
     */
    @Column(name = "term_name")
    private String termName;

    @OneToMany(mappedBy = "term")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<StudentCourse> studentCourses;

    /**
     * 学期ID
     */
    public Term setTermId(String termId) {
        this.termId = termId;
        return this;
    }

    /**
     * 学期ID
     */
    public String getTermId() {
        return termId;
    }

    /**
     * 学期名称
     */
    public Term setTermName(String termName) {
        this.termName = termName;
        return this;
    }

    /**
     * 学期名称
     */
    public String getTermName() {
        return termName;
    }

    @Override
    public String toString() {
        return "Term{" +
                "termId=" + termId + '\'' +
                "termName=" + termName + '\'' +
                '}';
    }
}
