package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private long id;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "item_id")
    private long itemId;

    private int orderPrice;

    private int count;

}
