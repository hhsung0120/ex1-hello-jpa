package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //이렇게 잡아주지 않으면 싱글테이블 (디폴트)전략으로 테이블이 생성된다
// create table item (
//       dtype varchar(31) not null,
//        item_id bigint not null,
//        name varchar(255),
//        price integer not null,
//        stock_quantity integer not null,
//        artist varchar(255),
//        author varchar(255),
//        isbn varchar(255),
//        actor varchar(255),
//        director varchar(255),
//        primary key (item_id)
//    ) engine=InnoDB
@DiscriminatorColumn(name = "type_test") //Dtype 있는게 좋다고 하심 컬럼 이름을 변경하려면 name 을 주면 된다.
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
