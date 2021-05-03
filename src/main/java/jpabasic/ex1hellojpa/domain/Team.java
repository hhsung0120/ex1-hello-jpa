package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
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
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
}
