package com.racepace.runsapi.run;

import jakarta.persistence.*;

@Entity
@Table
public class Run {

    @Id
    @SequenceGenerator(
            name = "run_sequence",
            sequenceName = "run_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "run_sequence"
    )
    private Long id;
    private String title;
    private String distance;
    private String description;
    private String raceType;


    public Run(){

    }

    public Run(Long id, String title, String distance, String description, String raceType){
        this.id = id;
        this.title = title;
        this.distance = distance;
        this.description = description;
        this.raceType = raceType;

    }

    public Run(String title, String distance, String description, String raceType){
        this.title = title;
        this.distance = distance;
        this.description = description;
        this.raceType = raceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRaceType(){
        return raceType;
    }

    public void setRaceType(String raceType){
        this.raceType = raceType;
    }

    @Override
    public String toString() {
        return "Run{" +
                "title='" + title + '\'' +
                ", distance='" + distance + '\'' +
                ", description='" + description + '\'' +
                ", raceType='" + raceType + '\'' +
                '}';
    }
}
