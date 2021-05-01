package jpabasic.ex1hellojpa.service;

import jpabasic.ex1hellojpa.domain.Team;
import jpabasic.ex1hellojpa.repository.JpaTestRepository;
import org.springframework.stereotype.Service;

@Service
public class JpaService {

    final private JpaTestRepository jpaTestRepository;
    private JpaService(JpaTestRepository jpaTestRepository){
        this.jpaTestRepository = jpaTestRepository;
    }


    public void createTest() {
        Team team = new Team();
        team.setName("team1");
        System.out.println("================");
        jpaTestRepository.save(team);
        System.out.println("================");
        System.out.println(team.getId());
        System.out.println("테스트");
    }
}
