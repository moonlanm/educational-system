package edu.hubu.commons.repository.student;

import edu.hubu.commons.model.student.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ScoreRepository extends JpaRepository<Score, String>, JpaSpecificationExecutor<Score> {

}