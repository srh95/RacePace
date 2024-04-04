package com.racepace.runsapi.run;

import com.racepace.runsapi.exception.RunNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/** Handles requests passed by the Controller and accesses the database */
public class RunService {
    private final RunRepository runRepository;

    @Autowired
    public RunService(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    public List<Run> getRuns(){
        return runRepository.findAll();
    }

    public Run findRunByTitle(String title){
        return runRepository.findRunByTitle(title)
                .orElseThrow(() -> new RunNotFound("Run by title " + title + " was not found."));
    }

    public Run findRunById(Long id){
        return runRepository.findRunById(id)
                .orElseThrow(() -> new RunNotFound("Run by title " + id + " was not found."));
    }

    public void addNewRun(Run run) {
        Optional<Run> runOptional = runRepository.findRunByTitle(run.getTitle());
        if (runOptional.isPresent()){
            throw new IllegalStateException("That title is taken.");
        }
        runRepository.save(run);
    }

    public void deleteRun(Long runId){
        boolean exists = runRepository.existsById(runId);

        if (!exists){
            throw new IllegalStateException("Run with id " + runId + " does not exist");
        }
        runRepository.deleteById(runId);
    }

    public void updateRun(Long runId, Run runDetails){
        Run run = findRunById(runId);

        run.setTitle(runDetails.getTitle());
        run.setDescription(runDetails.getDescription());
        run.setRaceType(runDetails.getRaceType());
        run.setDistance(runDetails.getDistance());

        runRepository.save(run);
    }
}
