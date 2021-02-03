package edu.hubu.commons.repository.admin;

import edu.hubu.commons.model.admin.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TermRepository extends JpaRepository<Term, String>, JpaSpecificationExecutor<Term> {

}