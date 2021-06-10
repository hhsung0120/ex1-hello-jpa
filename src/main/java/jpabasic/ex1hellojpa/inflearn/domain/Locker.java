package jpabasic.ex1hellojpa.inflearn.domain;

import javax.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lockere_id")
    private Long id;

    private String name;



}
