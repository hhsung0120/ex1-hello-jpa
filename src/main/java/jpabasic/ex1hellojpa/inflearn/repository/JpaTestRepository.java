package jpabasic.ex1hellojpa.inflearn.repository;

import jpabasic.ex1hellojpa.inflearn.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTestRepository extends JpaRepository<Team, Long> {
}
