package kea.yaw.the24hourexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sex;
    private int age;
    private String club;

    @ManyToMany
    private Set<Discipline> disciplines;

    public Athlete(String name, String sex, int age, String club, Set<Discipline> disciplines) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.club = club;
        this.disciplines = disciplines;
    }
}
