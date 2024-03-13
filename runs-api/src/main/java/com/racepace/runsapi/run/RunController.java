package com.racepace.runsapi.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/run")
public class RunController {

    private final RunService runService;

    @Autowired
    public RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping
    public List<Run> getRuns() {
        return runService.getRuns();
    }

    @PostMapping
    public void registerNewRun(@RequestBody Run run) {
        runService.addNewRun(run);
    }

    @DeleteMapping(path = "{runId}")
    public void deleteRun(@PathVariable("runId") Long runId) {
        runService.deleteRun(runId);
    }
}
