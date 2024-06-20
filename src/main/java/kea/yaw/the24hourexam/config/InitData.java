package kea.yaw.the24hourexam.config;

import kea.yaw.the24hourexam.model.Athlete;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    ;


    @Override
    public void run(String... args) throws Exception {
        initData();

    }

    public void initData() {
        System.out.println("Initializing data");
        createAthletes();

    }

    public void createAthletes() {




    }

    }




