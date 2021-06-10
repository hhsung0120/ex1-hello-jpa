package jpabasic.ex1hellojpa.fastcampus.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime creaeteAt;
    private LocalDateTime updateAt;

}
