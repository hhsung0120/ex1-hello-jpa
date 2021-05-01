package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
