package kea.yaw.the24hourexam.model;

import jakarta.persistence.*;
import kea.yaw.the24hourexam.enums.EnumResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @Enumerated(EnumType.STRING)
    private EnumResultType resultType;

    private LocalDate date;
    private Double  resultValue;


    public Result(Athlete athlete, Discipline discipline) {
        this.athlete = athlete;
        this.discipline = discipline;
    }

    public Result(Athlete athlete, Discipline discipline, EnumResultType resultType, LocalDate date, Double resultValue) {
        this.athlete = athlete;
        this.discipline = discipline;
        this.resultType = resultType;
        this.date = date;
        this.resultValue = resultValue;
    }


}
