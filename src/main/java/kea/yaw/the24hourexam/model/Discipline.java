package kea.yaw.the24hourexam.model;

import jakarta.persistence.*;
import kea.yaw.the24hourexam.enums.EnumResultType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    @Enumerated(EnumType.STRING)
    EnumResultType resultType;


    public Discipline(String name, EnumResultType resultType) {
        this.name = name;
        this.resultType = resultType;
    }
}
