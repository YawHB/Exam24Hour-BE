package kea.yaw.the24hourexam.config;

import kea.yaw.the24hourexam.enums.EnumResultType;
import kea.yaw.the24hourexam.model.Athlete;
import kea.yaw.the24hourexam.model.Discipline;
import kea.yaw.the24hourexam.model.Result;
import kea.yaw.the24hourexam.repository.AthleteRepository;
import kea.yaw.the24hourexam.repository.DisciplineRepository;
import kea.yaw.the24hourexam.repository.ResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    ;
    private final AthleteRepository athleteRepository;
    private final DisciplineRepository disciplineRepository;
    private final ResultRepository resultRepository;

    public InitData(AthleteRepository athleteRepository, DisciplineRepository disciplineRepository, ResultRepository resultRepository) {
        this.athleteRepository = athleteRepository;
        this.disciplineRepository = disciplineRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();

    }

    public void initData() {
        System.out.println("Initializing data");
        createDisciplines();
        createAthletes();
        createResults();

    }


    public void createDisciplines() {
        if (disciplineRepository.count() > 0) {
            System.out.println("Disciplines already exist");
        } else {
            System.out.println("Creating disciplines");

            // Create each discipline as a separate variable
            Discipline spydkast = new Discipline("Spydkast", EnumResultType.DISTANCE);
            Discipline løb100m = new Discipline("100 meter løb", EnumResultType.TIME);
            Discipline højdespring = new Discipline("Højdespring", EnumResultType.DISTANCE);
            Discipline længdespring = new Discipline("Længdespring", EnumResultType.DISTANCE);
            Discipline kuglestød = new Discipline("Kuglestød", EnumResultType.DISTANCE);
            Discipline stangspring = new Discipline("Stangspring", EnumResultType.DISTANCE);
            Discipline maraton = new Discipline("Maraton", EnumResultType.TIME);
            Discipline hækkeløb = new Discipline("Hækkeløb", EnumResultType.TIME);
            Discipline stafetløb = new Discipline("Stafetløb", EnumResultType.TIME);
            Discipline trekamp = new Discipline("Trekamp", EnumResultType.POINTS);
            Discipline femkamp = new Discipline("Femkamp", EnumResultType.POINTS);

            // Save disciplines in a Set
            Set<Discipline> disciplinesToCreate = Set.of(
                    spydkast, løb100m, højdespring, længdespring, kuglestød, stangspring, maraton, hækkeløb, stafetløb, trekamp, femkamp
            );

            // Save disciplines in the database
            disciplineRepository.saveAll(disciplinesToCreate);
        }
    }

    public void createAthletes() {
        if (athleteRepository.count() > 0) {
            System.out.println("Athletes already exist");
        } else {
            System.out.println("Creating athletes");

// Fetch disciplines from the database
            Discipline spydkast = disciplineRepository.findByName("Spydkast").orElseThrow(() -> new RuntimeException("Discipline not found: Spydkast"));
            Discipline løb100m = disciplineRepository.findByName("100 meter løb").orElseThrow(() -> new RuntimeException("Discipline not found: 100 meter løb"));
            Discipline højdespring = disciplineRepository.findByName("Højdespring").orElseThrow(() -> new RuntimeException("Discipline not found: Højdespring"));
            Discipline længdespring = disciplineRepository.findByName("Længdespring").orElseThrow(() -> new RuntimeException("Discipline not found: Længdespring"));

            Set<Athlete> athletesToCreate = Set.of(
                    new Athlete("James", "M", 25, " København", Set.of(spydkast, løb100m)),
                    new Athlete("John", "M", 24, " Århus", Set.of(løb100m, højdespring)),
                    new Athlete("Jane", "F", 23, " Odense", Set.of(spydkast, længdespring)),
                    new Athlete("Julia", "F", 22, " København", Set.of(højdespring, længdespring)),
                    new Athlete("Jack", "M", 21, " Århus", Set.of(spydkast, højdespring)),
                    new Athlete("Jill", "F", 20, " Odense", Set.of(løb100m, længdespring)),
                    new Athlete("Jeremy", "M", 19, " København", Set.of(spydkast, løb100m)),
                    new Athlete("Jessica", "F", 18, " Århus", Set.of(højdespring, længdespring)),
                    new Athlete("Jacob", "M", 17, " Odense", Set.of(spydkast, løb100m)),
                    new Athlete("Jasmine", "F", 16, " København", Set.of(løb100m, højdespring))
            );

                    // ...

            athleteRepository.saveAll(athletesToCreate);
        }
    }

    private void createResults() {
        System.out.println("Creating results");
        // Fetch athletes from the database
        Athlete james = athleteRepository.findByName("James").orElseThrow(() -> new RuntimeException("Athlete not found: James"));
        Athlete john = athleteRepository.findByName("John").orElseThrow(() -> new RuntimeException("Athlete not found: John"));
        Athlete jane = athleteRepository.findByName("Jane").orElseThrow(() -> new RuntimeException("Athlete not found: Jane"));
        Athlete julia = athleteRepository.findByName("Julia").orElseThrow(() -> new RuntimeException("Athlete not found: Julia"));
        Athlete jack = athleteRepository.findByName("Jack").orElseThrow(() -> new RuntimeException("Athlete not found: Jack"));
        Athlete jill = athleteRepository.findByName("Jill").orElseThrow(() -> new RuntimeException("Athlete not found: Jill"));
        Athlete jeremy = athleteRepository.findByName("Jeremy").orElseThrow(() -> new RuntimeException("Athlete not found: Jeremy"));
        Athlete jessica = athleteRepository.findByName("Jessica").orElseThrow(() -> new RuntimeException("Athlete not found: Jessica"));
        Athlete jacob = athleteRepository.findByName("Jacob").orElseThrow(() -> new RuntimeException("Athlete not found: Jacob"));
        Athlete jasmine = athleteRepository.findByName("Jasmine").orElseThrow(() -> new RuntimeException("Athlete not found: Jasmine"));

        // Fetch disciplines from the database
        Discipline spydkast = disciplineRepository.findByName("Spydkast").orElseThrow(() -> new RuntimeException("Discipline not found: Spydkast"));
        Discipline løb100m = disciplineRepository.findByName("100 meter løb").orElseThrow(() -> new RuntimeException("Discipline not found: 100 meter løb"));
        Discipline højdespring = disciplineRepository.findByName("Højdespring").orElseThrow(() -> new RuntimeException("Discipline not found: Højdespring"));
        Discipline længdespring = disciplineRepository.findByName("Længdespring").orElseThrow(() -> new RuntimeException("Discipline not found: Længdespring"));

        // Create results
        Set<Result> resultsToCreate = Set.of(
                new Result(james, spydkast, EnumResultType.DISTANCE, java.time.LocalDate.now(), 50.0),
        new Result(james, løb100m, EnumResultType.TIME, java.time.LocalDate.now(), 10.0),
        new Result(james, højdespring, EnumResultType.DISTANCE, java.time.LocalDate.now(), 2.0),
        new Result(john, løb100m, EnumResultType.TIME, java.time.LocalDate.now(), 9.5),
        new Result(jane, spydkast, EnumResultType.DISTANCE, java.time.LocalDate.now(), 45.0),
        new Result(jane, længdespring, EnumResultType.DISTANCE, java.time.LocalDate.now(), 4.0)

        );
        resultRepository.saveAll(resultsToCreate);



    }
}




