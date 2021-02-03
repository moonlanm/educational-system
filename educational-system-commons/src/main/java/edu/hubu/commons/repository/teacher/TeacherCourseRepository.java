package edu.hubu.commons.repository.teacher;

import edu.hubu.commons.model.teacher.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, String>, JpaSpecificationExecutor<TeacherCourse> {

}