package jpabasic.ex1hellojpa.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Persistence;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        Persistence.createEntityManagerFactory("test");

        return "JPA Example";
    }
}
