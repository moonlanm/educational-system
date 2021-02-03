package edu.hubu.commons.repository.teacher;

import edu.hubu.commons.model.teacher.TeacherSelectCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherSelectCourseRepository extends JpaRepository<TeacherSelectCourse, String>, JpaSpecificationExecutor<TeacherSelectCourse> {

}