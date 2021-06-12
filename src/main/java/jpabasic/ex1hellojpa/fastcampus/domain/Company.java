package jpabasic.ex1hellojpa.fastcampus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_nation")
    private String companyNation;

    public Company(String companyName, String companyNation){
        this.companyName = companyName;
        this.companyNation = companyNation;
        super.setCreaeteAt(new Date());
        super.setUpdateAt(new Date());
    }

}
