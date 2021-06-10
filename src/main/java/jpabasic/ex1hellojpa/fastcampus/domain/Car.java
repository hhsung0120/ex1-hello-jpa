package jpabasic.ex1hellojpa.fastcampus.domain;

import javax.persistence.*;

@Entity
public class Car extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_name")
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "passenger_capacity")
    private Integer pessengerCapacity;
}
