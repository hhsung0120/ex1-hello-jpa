package jpabasic.ex1hellojpa.inflearn.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    //셀프 조인
    //나를 기준으로 부모 카테고리
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    //셀프 조인
    //나를 기준으로 자식
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //하나의 카테고리에 여러 아이템
    //중간 테이블 만드는 과정
    @ManyToMany
    @JoinTable(name = "category_item"
                , joinColumns  = @JoinColumn(name = "category_id") //내가 조인하는 컬럼
                , inverseJoinColumns = @JoinColumn(name = "item_id") // 반대쪽이 조인하는 컬럼
    )
    private List<Item> items = new ArrayList<>();

}
