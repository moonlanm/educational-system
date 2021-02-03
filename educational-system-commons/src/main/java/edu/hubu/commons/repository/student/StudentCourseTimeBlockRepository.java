package edu.hubu.commons.repository.student;

import edu.hubu.commons.model.student.StudentCourseTimeBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentCourseTimeBlockRepository extends JpaRepository<StudentCourseTimeBlock, String>, JpaSpecificationExecutor<StudentCourseTimeBlock> {

}