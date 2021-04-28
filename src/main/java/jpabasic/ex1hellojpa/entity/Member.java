package jpabasic.ex1hellojpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="member")
public class Member {

    @Id
    private long id;

    @Column(name="name", insertable = true, updatable = true, length = 10) //등록, 변경 가능 여부 옵션, 자릿수 10
    private String name;

    @Column(nullable = false, unique = true) //not null 제약조건, 유니크 제약 조건
    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roloeType;

    @Column(columnDefinition = "varchar(20) default 'empty'")
    private String test;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDodifiedDate;

    @Lob
    private String description;

    public Member(){}

}
