package jpabasic.ex1hellojpa.repository;

import jpabasic.ex1hellojpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
