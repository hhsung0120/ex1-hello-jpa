package jpabasic.ex1hellojpa.fastcampus;

import jpabasic.ex1hellojpa.fastcampus.domain.Company;
import jpabasic.ex1hellojpa.fastcampus.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AppInitializer {

    final private CompanyService companyService;

    @PostConstruct
    private void init(){
        Company company = new Company();
        company.setUpdateAt(new Date());
        company.setCreaeteAt(new Date());
        company.setGetCompanyNation("이탈리아");
        company.setCompanyName("페라리");

        Company company1 = new Company();
        company1.setUpdateAt(new Date());
        company1.setCreaeteAt(new Date());
        company1.setGetCompanyNation("이름 초기 시작 ?");
        company1.setCompanyName("오 초기 시작 하면서 되나 ");

        companyService.save(company);
        companyService.save(company1);
    }

    @PreDestroy
    private void destroy(){
        System.out.println("종료 직전이닷");
    }
}
