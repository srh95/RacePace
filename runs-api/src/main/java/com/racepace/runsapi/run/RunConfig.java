package com.racepace.runsapi.run;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RunConfig {

    @Bean
    CommandLineRunner commandLineRunner(RunRepository repository){
        return args -> {
            Run mileRepeats = new Run(
                    "Mile Repeats",
                    "5 miles",
                    "1 mile warmup, 3x1 mile repeats @ goal 5k pace, 1 mile cooldown",
                    "5k"
            );

            Run ladder = new Run(
                    "Up and Down Ladder",
                    "5 miles",
                    "1 mile warmup, 400-800-1200-1200-800-400 with 1.5-2min recovery walk in between." +
                            "1200s should be done at goal 5k pace, 400s and 800s should be done at about 20s faster " +
                            "than goal 5k pace.",
                    "5k"
            );

            repository.saveAll(
                    List.of(mileRepeats, ladder)
            );
        };
    }
}
