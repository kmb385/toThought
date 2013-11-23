package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.entities.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {

}
