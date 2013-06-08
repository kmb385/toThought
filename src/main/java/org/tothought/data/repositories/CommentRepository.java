package org.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.data.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
