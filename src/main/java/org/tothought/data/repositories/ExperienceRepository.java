package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.entities.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
