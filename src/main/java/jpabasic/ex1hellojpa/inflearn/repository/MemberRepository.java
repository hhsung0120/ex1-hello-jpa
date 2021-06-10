package jpabasic.ex1hellojpa.inflearn.repository;

import jpabasic.ex1hellojpa.inflearn.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
