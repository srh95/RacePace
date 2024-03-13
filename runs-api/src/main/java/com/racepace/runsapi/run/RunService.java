package com.racepace.runsapi.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RunService {
    private final RunRepository runRepository;

    @Autowired
    public RunService(RunRepository runRepository){
        this.runRepository = runRepository;
    }

    public List<Run> getRuns(){
        return runRepository.findAll();
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
}
