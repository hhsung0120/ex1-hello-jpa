package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    /*@Column(name = "team_id")
    private Long teamId;*/
    //객체지향
    //Member 입장에선 team 이 다대일 이기때문에 ManyToOne으로 설정
    //어노테이션은 디비매핑을 하기 위한것이기때문에 디비 입장에서 작성
    //insert 시점에 cascade = CascadeType.ALL 옵션이 없으면 member 객체에서 FK로 쓰이는 값이 아직 생기지(Long id) 않아서
    //TransientPropertyValueException 오류 발생생
    @JoinColumn(name = "team_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;

    private String name;

    private String city;

    private String street;

    private String zipcode;

}
