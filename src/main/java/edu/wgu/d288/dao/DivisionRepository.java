package edu.wgu.d288.dao;

import edu.wgu.d288.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface DivisionRepository extends JpaRepository<Division, Long> {
}