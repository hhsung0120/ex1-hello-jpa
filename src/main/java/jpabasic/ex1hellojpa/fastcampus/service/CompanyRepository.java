package jpabasic.ex1hellojpa.fastcampus.service;

import jpabasic.ex1hellojpa.fastcampus.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
