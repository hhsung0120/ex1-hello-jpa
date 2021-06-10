package jpabasic.ex1hellojpa.inflearn.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Long id;

/*    @Column(name = "order_id")
    private Long orderId;*/
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    /*@Column(name = "item_id")
    private Long itemId;*/
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;

    private int count;

}
