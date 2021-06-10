package jpabasic.ex1hellojpa.inflearn.controller;

import jpabasic.ex1hellojpa.inflearn.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @GetMapping("/shop/index")
    public String shopHome(){
        Member member = new Member();
        return "22";
    }
}
