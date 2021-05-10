package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    //좋지 않은 구조이지만 예제니까 넣었음
    //Orders에 member_id 가 있기 때문에 orders 테이블만 보면 된다 굳이 member 가 orderList 를 가지고 있을 필요 없음
    //김영한님은 이렇게 짠 코드는 나쁜코드라고 했음, 주문따로 회원따로 보는게 맞다고 하심
    @OneToMany(mappedBy = "member")
    List<Orders> orderList = new ArrayList<>();



    private String name;

    private String city;

    private String street;

    private String zipcode;
}
