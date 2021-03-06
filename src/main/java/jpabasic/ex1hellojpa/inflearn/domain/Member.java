package jpabasic.ex1hellojpa.inflearn.domain;

import jpabasic.ex1hellojpa.inflearn.domain.common.Address;
import jpabasic.ex1hellojpa.inflearn.domain.common.Period;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

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


    //기간 Period
    /* private LocalDateTime startDate;
    private LocalDateTime endDate;*/
    @Embedded
    private Period workPeriod;

    //주소
    /*private String city;
    private String street;
    private String zipcode;*/
    @Embedded
    private Address homeAddress;

    //한 엔티티에서 같은 타입을 동시에 사용할때 @AttributeOverrides 를 사용하면 된다
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",
                    column=@Column(name = "WORK_CITY")),
            @AttributeOverride(name="street",
                    column=@Column(name = "WORK_STREET")),
            @AttributeOverride(name="zipcode",
                    column=@Column(name = "WORK_ZIPCODE"))
    })
    private Address homeAddress2;

    //값타입 컬렉선 예제
    //엔티티로 만들지 않아도 테이블 생성된다.
    //컬렉션 데이터들은 1:다 로 풀어서 저장해야 한다
    //값타입 컬렉션은 모든 키를 묶어서 기본키로 구성해야한다 null X 중복저장 X
    //remove 할 경우 전체를 삭제하고 컬렉션 갯수 만큼 다시 저장을한다.
    //또한 삭제를 할경우 해쉬가 안맞으면 쿼리 자체는
    //delete from address where member_id = ?  형식으로 쿼리가 나가지만 실제로는 호출된 값과 삭제 하려는 값을
    //해쉬로 비교하여 일치하는것만 삭제 한다, (여기서 !! 해쉬코드, 이퀄스 함수가 제대로 구현이 되 있어야함)
    //위험하기때문에 실무에선 1대다로 풀어서 사용
    //어떨때 사용하냐면 내가 좋아하는 음식이 뭔지 저장할때 ex 체크박스 타입, 셀렉트박스 타입
    @ElementCollection
    @CollectionTable(name = "favorite_food", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "food_name")
    private Set<String> favoriteFoods = new HashSet<>();



    @ElementCollection
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "member_id"))
    private List<Address> addressHistory = new ArrayList<>();




}
