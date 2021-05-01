package jpabasic.ex1hellojpa.repository;

import jpabasic.ex1hellojpa.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTestRepository extends JpaRepository<Team, Long> {
}
