package com.gchsj.entity;

import com.gchsj.types.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STUDENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "STUDENT_NAME", length = 50, nullable = true, unique = false)
    private String name;

    @Transient
    private int age;

    @Column(name = "STUDENT_BIRTH_DAY", length = 50, nullable = true, unique = false)
    private LocalDateTime birthDay;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
