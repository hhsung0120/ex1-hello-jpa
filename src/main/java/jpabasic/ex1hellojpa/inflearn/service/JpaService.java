package jpabasic.ex1hellojpa.inflearn.service;

import jpabasic.ex1hellojpa.inflearn.domain.Member;
import jpabasic.ex1hellojpa.inflearn.domain.Movie;
import jpabasic.ex1hellojpa.inflearn.domain.Team;
import jpabasic.ex1hellojpa.inflearn.domain.common.Address;
import jpabasic.ex1hellojpa.inflearn.domain.common.Period;
import jpabasic.ex1hellojpa.inflearn.repository.JpaTestRepository;
import jpabasic.ex1hellojpa.inflearn.repository.MemberRepository;
import jpabasic.ex1hellojpa.inflearn.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
//@AllArgsConstructor 을 사용하지 않는 이유는 모든 필드를 생성자 파라메터로 만들기 때문, @value 등 baen 에서 관리되지 않는 객체를 선언시 오류
//final 로 생성된 것들만 생성자 파라메터로 관리하기 위해 @RequiredArgsConstructor 사용
public class JpaService {

    private final JpaTestRepository jpaTestRepository;
    private final MemberRepository memberRepository;
    private final MovieRepository movieRepository;

    /*private JpaService(JpaTestRepository jpaTestRepository
            , MemberRepository memberRepository
            , MovieRepository movieRepository){
        this.jpaTestRepository = jpaTestRepository;
        this.memberRepository = memberRepository;
        this.movieRepository = movieRepository;
    }*/

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
//        member.setCity("서울");
//        member.setZipcode("1234");
        member.setHomeAddress(new Address("test1","test2","test3"));
        member.setWorkPeriod(new Period());

        Team team = new Team();
        team.setName("A 팀");

        member.setTeam(team);

        //컬렉션 저장
        member.getFavoriteFoods().add("치킨");
        member.getFavoriteFoods().add("피자");
        member.getFavoriteFoods().add("족발");
        member.getAddressHistory().add(new Address("old1","old1","old1"));
        member.getAddressHistory().add(new Address("old2","old2","old2"));

        memberRepository.save(member);
        System.out.println(member.getId());
    }

    public void selectMember(){
        Member member = memberRepository.findById(1L).get();

        System.out.println("쿼리 다 날리나");
        //List<Member> members = byId.get().getTeam().getMembers();
        System.out.println("쿼리 다 날리나2");

        Set<String> favoriteFoods = member.getFavoriteFoods();
        for(String t : favoriteFoods){
            System.out.println(t);
        }

/*        for (Member member1 : members) {
            System.out.println(member1.getName());
        }*/

    }

    public void saveMovie() {
        Movie movie = new Movie();
        movie.setDirector("aaa");
        movie.setActor("bbb");
        movie.setName("바람과 함께사라지다");
        movie.setPrice(10000);

        movieRepository.save(movie);
    }

    //삭제
    public void entityDelete(){
        Optional<Member> byId = memberRepository.findById(1L);

        byId.get().getFavoriteFoods().remove("치킨");
        byId.get().getFavoriteFoods().add("츼킌");

        //hashCode, equals 메서드를 제대로 구현하지 않으면 hash 비교가 안돼서 삭제가 안된다 !!! 주의 !!
        byId.get().getAddressHistory().remove(new Address("old3","old3","old3"));

        //저장은 된다
        byId.get().getAddressHistory().add(new Address("old5","old4","old4"));

    }
}

