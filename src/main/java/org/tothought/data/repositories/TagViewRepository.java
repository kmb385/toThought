package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.views.TagView;


public interface TagViewRepository extends JpaRepository<TagView, Integer> {

}
