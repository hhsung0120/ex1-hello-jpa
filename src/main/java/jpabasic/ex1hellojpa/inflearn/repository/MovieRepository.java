package jpabasic.ex1hellojpa.inflearn.repository;

import jpabasic.ex1hellojpa.inflearn.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
