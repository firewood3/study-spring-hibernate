package com.gchsj.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
//@Builder
public class Person {
/*
      GenerationType을 auto로 하면
      hibernate_sequence 테이블이 생성되고 next_val이 모든 테이블의 id에 공유된다.
      GenerateType을 Identity로 하면
      hibernate_sequence 테이블이 생성되지도 않고 각자 테이블에서 auto increment 된다.
 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Builder
    public Person(String name) {
        this.name = name;
    }
}
