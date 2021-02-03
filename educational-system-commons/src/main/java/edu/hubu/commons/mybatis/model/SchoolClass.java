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
public class SchoolClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private String schoolClassId;

    private Boolean schoolClassIsDeleted;

    private Boolean schoolClassIsForbidden;

    private String schoolClassName;

    private String schoolClassFacultyId;

    private String schoolClassMajorId;

    private String schoolClassTeacherId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(String schoolClassId) {
        this.schoolClassId = schoolClassId;
    }
    public Boolean getSchoolClassIsDeleted() {
        return schoolClassIsDeleted;
    }

    public void setSchoolClassIsDeleted(Boolean schoolClassIsDeleted) {
        this.schoolClassIsDeleted = schoolClassIsDeleted;
    }
    public Boolean getSchoolClassIsForbidden() {
        return schoolClassIsForbidden;
    }

    public void setSchoolClassIsForbidden(Boolean schoolClassIsForbidden) {
        this.schoolClassIsForbidden = schoolClassIsForbidden;
    }
    public String getSchoolClassName() {
        return schoolClassName;
    }

    public void setSchoolClassName(String schoolClassName) {
        this.schoolClassName = schoolClassName;
    }
    public String getSchoolClassFacultyId() {
        return schoolClassFacultyId;
    }

    public void setSchoolClassFacultyId(String schoolClassFacultyId) {
        this.schoolClassFacultyId = schoolClassFacultyId;
    }
    public String getSchoolClassMajorId() {
        return schoolClassMajorId;
    }

    public void setSchoolClassMajorId(String schoolClassMajorId) {
        this.schoolClassMajorId = schoolClassMajorId;
    }
    public String getSchoolClassTeacherId() {
        return schoolClassTeacherId;
    }

    public void setSchoolClassTeacherId(String schoolClassTeacherId) {
        this.schoolClassTeacherId = schoolClassTeacherId;
    }


}
