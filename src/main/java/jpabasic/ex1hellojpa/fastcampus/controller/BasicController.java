package jpabasic.ex1hellojpa.fastcampus.controller;

import jpabasic.ex1hellojpa.fastcampus.domain.CompanyInputDto;
import jpabasic.ex1hellojpa.fastcampus.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class BasicController {

    final private CompanyService companyService;

    @GetMapping("/fIndex")
    public String fIndex(){
        return "/fIndex";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute CompanyInputDto companyInputDto){
        System.out.println(companyInputDto.toString());
        companyService.saveCompanyInputDto(companyInputDto);
        return "/fIndex";
    }

    @GetMapping("/companyList")
    public ModelAndView companyList(@PageableDefault Pageable pageable){
        return new ModelAndView("/companyList")
                  .addObject("companyList", companyService.getCompanyPage(pageable));
    }

}
