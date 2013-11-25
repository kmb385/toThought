package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.entities.Thought;

public interface ThoughtRepository extends JpaRepository<Thought, Integer> {

}
