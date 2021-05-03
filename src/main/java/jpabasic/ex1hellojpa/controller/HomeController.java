package jpabasic.ex1hellojpa.controller;

import jpabasic.ex1hellojpa.service.JpaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    final private JpaService jpaService;
    private HomeController(JpaService jpaService){
        this.jpaService = jpaService;
    }

    @GetMapping("/")
    public String home(){
        //jpaService.createTest();
        jpaService.createMember();
        return "JPA Example";
    }

    @GetMapping("/members")
    public String members(){
        jpaService.selectMember();
        return "JPA Example";
    }
}
