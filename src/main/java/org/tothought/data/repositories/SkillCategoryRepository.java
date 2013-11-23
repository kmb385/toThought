package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.entities.SkillCategory;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Integer> {

}
