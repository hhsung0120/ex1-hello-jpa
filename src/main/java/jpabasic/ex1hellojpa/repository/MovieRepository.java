package jpabasic.ex1hellojpa.repository;

import jpabasic.ex1hellojpa.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
