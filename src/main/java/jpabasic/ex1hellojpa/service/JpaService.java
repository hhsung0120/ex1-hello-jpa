package jpabasic.ex1hellojpa.service;

import jpabasic.ex1hellojpa.domain.Member;
import jpabasic.ex1hellojpa.domain.Movie;
import jpabasic.ex1hellojpa.domain.Team;
import jpabasic.ex1hellojpa.repository.JpaTestRepository;
import jpabasic.ex1hellojpa.repository.MemberRepository;
import jpabasic.ex1hellojpa.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaService {

    final private JpaTestRepository jpaTestRepository;
    final private MemberRepository memberRepository;
    final private MovieRepository movieRepository;

    private JpaService(JpaTestRepository jpaTestRepository
            , MemberRepository memberRepository
            , MovieRepository movieRepository){
        this.jpaTestRepository = jpaTestRepository;
        this.memberRepository = memberRepository;
        this.movieRepository = movieRepository;
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


    public void createMember() {
        Member member = new Member();
        member.setName("홍길동");
        member.setCity("서울");
        member.setZipcode("1234");

        Team team = new Team();
        team.setName("A 팀");

        member.setTeam(team);
        memberRepository.save(member);
        System.out.println(member.getId());
    }

    public void selectMember(){
        Optional<Member> byId = memberRepository.findById(1L);
        List<Member> members = byId.get().getTeam().getMembers();

        for (Member member1 : members) {
            System.out.println(member1.getName());
        }



    }

    public void saveMovie() {
        Movie movie = new Movie();
        movie.setDirector("aaa");
        movie.setActor("bbb");
        movie.setName("바람과 함께사라지다");
        movie.setPrice(10000);

        movieRepository.save(movie);
    }
}

