package jpabasic.ex1hellojpa.inflearn.controller;

import jpabasic.ex1hellojpa.inflearn.service.JpaService;
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

    @GetMapping("/delete")
    public String delete(){
        jpaService.entityDelete();
        return "JPA Example";
    }

    @GetMapping("/movie")
    public String movieTest(){
        jpaService.saveMovie();
        return "movie Example";
    }





}
