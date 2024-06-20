package kea.yaw.the24hourexam.config;

import kea.yaw.the24hourexam.model.Athlete;
import kea.yaw.the24hourexam.model.Discipline;
import kea.yaw.the24hourexam.repository.AthleteRepository;
import kea.yaw.the24hourexam.repository.DisciplineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    ;
    private final AthleteRepository athleteRepository;
    private final DisciplineRepository disciplineRepository;

    public InitData(AthleteRepository athleteRepository, DisciplineRepository disciplineRepository) {
        this.athleteRepository = athleteRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();

    }

    public void initData() {
        System.out.println("Initializing data");
        createDisciplines();
        createAthletes();

    }


    public void createDisciplines() {
        if (disciplineRepository.count() > 0) {
            System.out.println("Disciplines already exist");
        } else {
            System.out.println("Creating disciplines");

            // Create each discipline as a separate variable
            Discipline spydkast = new Discipline("Spydkast");
            Discipline løb100m = new Discipline("100 meter løb");
            Discipline højdespring = new Discipline("Højdespring");
            Discipline længdespring = new Discipline("Længdespring");
            Discipline kuglestød = new Discipline("Kuglestød");
            Discipline stangspring = new Discipline("Stangspring");
            Discipline maraton = new Discipline("Maraton");
            Discipline hækkeløb = new Discipline("Hækkeløb");
            Discipline stafetløb = new Discipline("Stafetløb");
            Discipline trekamp = new Discipline("Trekamp");
            Discipline femkamp = new Discipline("Femkamp");
            Discipline seksikamp = new Discipline("Seksikamp");
            Discipline syvkamp = new Discipline("Syvkamp");
            Discipline tikamp = new Discipline("Ti-kamp");

            // Save disciplines in a Set
            Set<Discipline> disciplinesToCreate = Set.of(
                    spydkast, løb100m, højdespring, længdespring, kuglestød, stangspring, maraton, hækkeløb, stafetløb, trekamp, femkamp, seksikamp, syvkamp, tikamp
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
            Discipline spydkast = disciplineRepository.findByName("Spydkast");
            Discipline løb100m = disciplineRepository.findByName("100 meter løb");
            Discipline højdespring = disciplineRepository.findByName("Højdespring");
            Discipline længdespring = disciplineRepository.findByName("Længdespring");


            Set<Athlete> athletesToCreate = Set.of(
                    new Athlete("James", "M", 25, "klub København", Set.of(spydkast, løb100m)),
            new Athlete("John", "M", 24, "klub Århus", Set.of(løb100m, højdespring)),
                    new Athlete("Jane", "F", 23, "klub Odense", Set.of(spydkast, længdespring)),
                    new Athlete("Julia", "F", 22, "klub København", Set.of(højdespring, længdespring)),
                    new Athlete("Jack", "M", 21, "klub Århus", Set.of(spydkast, højdespring)),
                    new Athlete("Jill", "F", 20, "klub Odense", Set.of(løb100m, længdespring)),
                    new Athlete("Jeremy", "M", 19, "klub København", Set.of(spydkast, løb100m)),
                    new Athlete("Jessica", "F", 18, "klub Århus", Set.of(højdespring, længdespring)),
                    new Athlete("Jacob", "M", 17, "klub Odense", Set.of(spydkast, løb100m)),
                    new Athlete("Jasmine", "F", 16, "klub København", Set.of(løb100m, højdespring))

                    // ...
            );
            athleteRepository.saveAll(athletesToCreate);
        }
    }
}




