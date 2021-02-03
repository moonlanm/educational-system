package edu.hubu.commons.repository.student;

import edu.hubu.commons.model.student.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentScoreRepository extends JpaRepository<StudentScore, String>, JpaSpecificationExecutor<StudentScore> {

}