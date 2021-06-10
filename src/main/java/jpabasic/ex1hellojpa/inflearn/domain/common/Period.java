package jpabasic.ex1hellojpa.inflearn.domain.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
//공통으로 묶어서 클래스를 재사용 하고자 할때 Emdeddable 을 사용
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
