package jpabasic.ex1hellojpa.fastcampus.service;

import jpabasic.ex1hellojpa.fastcampus.domain.Company;
import jpabasic.ex1hellojpa.fastcampus.domain.CompanyInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {

    final private CompanyRepository companyRepository;

    @Transactional
    public Company saveCompanyInputDto(CompanyInputDto companyInputDto){
        Company company = new Company();
        company.setCompanyName(companyInputDto.getCompanyName());
        company.setGetCompanyNation(companyInputDto.getCompanyNation());
        company.setCreaeteAt(new Date());
        company.setUpdateAt(new Date());

        return companyRepository.save(company);

    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
