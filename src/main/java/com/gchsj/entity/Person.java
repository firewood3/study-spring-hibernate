package com.gchsj.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PERSON_NAME", length = 50, nullable = true, unique = false)
    private String name;
}
