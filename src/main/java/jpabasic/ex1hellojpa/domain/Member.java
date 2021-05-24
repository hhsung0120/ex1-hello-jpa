package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    /*@Column(name = "team_id")
    private Long teamId;*/
    //객체지향
    //Member 입장에선 team 이 다대일 이기때문에 ManyToOne으로 설정
    //어노테이션은 디비매핑을 하기 위한것이기때문에 디비 입장에서 작성
    //insert 시점에 cascade = CascadeType.ALL 옵션이 없으면 member 객체에서 FK로 쓰이는 값이 아직 생기지(Long id) 않아서
    //cascade = CascadeType.ALL 특정 엔티티를 영속 상태로 만들때 연관된 엔티티도 함께 영속 상태로 만들어 준다.
    //부모엔티티를 저장할때 자식도(상속관계를 말하는게 아님) 같이 저장하고 싶을 때
    //TransientPropertyValueException 오류 발생생
    //CASCADE옵션이 여러가지가 있지만, ALL(모든 라이프사이클에 필요할때), PERSIST(저장할때만 사용) 두개만 거의 사용하자
    //하나의 부모가 자식들을 관리할때 의미가 있음!!(카테고리, 첨부파일 등 소유자가 하나일때)
    //casecade=all로 해도 부모 객체를 삭제하면 자식도 다 삭제됨(고아객체 삭제)
    //다른 엔티티와 연관관계가 있을때는 사용하지말자 (다른엔티티에서 team 데이터를 관여할때 !!)
    //다대일 단방향 연관관계 가장 많이 쓰임
    @JoinColumn(name = "team_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Team team;

    //좋지 않은 구조이지만 예제니까 넣었음
    //Orders에 member_id 가 있기 때문에 orders 테이블만 보면 된다 굳이 member 가 orderList 를 가지고 있을 필요 없음
    //김영한님은 이렇게 짠 코드는 나쁜코드라고 했음, 주문따로 회원따로 보는게 맞다고 하심
    @OneToMany(mappedBy = "member")
    List<Orders> orderList = new ArrayList<>();

/*    @OneToOne
    @JoinColumn(name = "lockere_id")
    private Locker locker;*/


    private String name;

    private String city;

    private String street;

    private String zipcode;
}
