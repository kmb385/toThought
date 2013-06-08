package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

}
