package jpabasic.ex1hellojpa.fastcampus.domain;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    private Date creaeteAt;
    private Date updateAt;

}
