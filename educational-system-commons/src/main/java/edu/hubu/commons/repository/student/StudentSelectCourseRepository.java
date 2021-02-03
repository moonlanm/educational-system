package edu.hubu.commons.repository.student;

import edu.hubu.commons.model.student.StudentSelectCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentSelectCourseRepository extends JpaRepository<StudentSelectCourse, String>, JpaSpecificationExecutor<StudentSelectCourse> {

}