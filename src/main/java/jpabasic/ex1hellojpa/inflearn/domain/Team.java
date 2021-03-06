package jpabasic.ex1hellojpa.inflearn.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//jpa 쓸때 @ToString 사용시 양방향 연관관계에서 무한루프 빠질 가능성이 큼
@Getter
@Setter
@Entity
public class Team {

    //AUTO로 돌릴경우 insert 할때 PK값을 넣기위해 3번의 액션이 일어남,
    //1. 시퀀스 셀렉트
    //2. 시퀀스 +1 업데이트
    //3. insert
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    //팀입장에서 팀에 소속된 멤버들을 가지고 오려고 한다
    //new 를 해줘야 null 포인트가 안남
    //팀 입장에선 하나의 팀에 여러 맴버이기 때문에 OneToMany
    //mappedBy 는 매핑할 변수를 적어준다.
    //mappedBy 는 읽기 전용이기때문에 insert update 시 jpa 에서 읽질 않는다.
    //객체 호출 시점에 lazy 지연로딩이면 no session 에러 나옴, 영속성 컨텍스트에 객체가 없기때문에 no session
    //쿼리 호출 시점에 즉시 로딩으로 처리
    //양방향은 거의 사용하지 않으며, 단방향으로 설계를 끝내야하고, 양방향은 필요하면 그때 추가
    //연관관계 주인은 !!! 외래키가 있는 쪽으로 한다 ex: Member 객체
    //다대일 양방향 연관관계
    //orphanRemoval = true 옵션은 members 컬렉션에서 remove 된 애를 db 에서도 삭제 한다. 오팔리므발
    //주의사항!!! 참조하는 곳이 하나일 때 사용해야함; 특정 엔티티가 개인 소유할 때, @OneToOne, @OneToMany
    //고아객체란 부모를 삭제하면 자식은 고아가 된다. 따라서 오팔리므발을 true 하게 되면 부모를 제거할 때 자식도 함께 제거 된다.
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member){
        members.add(member);
        member.setTeam(this);
    }
}
