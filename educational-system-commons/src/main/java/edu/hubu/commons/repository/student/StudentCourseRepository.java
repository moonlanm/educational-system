package edu.hubu.commons.repository.student;

import edu.hubu.commons.model.student.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, String>, JpaSpecificationExecutor<StudentCourse> {

}