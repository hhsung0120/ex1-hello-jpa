package jpabasic.ex1hellojpa.inflearn.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    //이렇게 하면 문제가 있다.
    //주문 한건을 셀렉트 후 그주문한 사람이 누군지 알려면 다시 멤버를 셀렉트 해야하는 객체지향스럽지 않은 일이 발생
    //아래 소스는 없어지고 private Member member; 처럼 객체를 참조 할 수 있도록 해야함
    //그래야 객체 그래프 탐색이 가능하며 참조가 없으므로 UML도 잘못 되었음, 현재 구조는 테이블 설계에 맞춘 방식
    //order 입장에서 나를 주문한 member 를 알아야하기때문에 아래처럼 처리
    //@Column(name="member_id")
    //private Long memberId;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "orders")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
