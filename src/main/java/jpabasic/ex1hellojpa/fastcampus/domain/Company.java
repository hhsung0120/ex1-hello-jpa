package jpabasic.ex1hellojpa.fastcampus.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_nation")
    private String getCompanyNation;
}
