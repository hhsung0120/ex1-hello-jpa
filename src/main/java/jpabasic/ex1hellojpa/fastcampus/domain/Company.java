package jpabasic.ex1hellojpa.fastcampus.domain;

import javax.persistence.*;

@Entity
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_nation")
    private String getCompanyNation;
}
