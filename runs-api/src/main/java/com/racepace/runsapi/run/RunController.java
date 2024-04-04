package com.racepace.runsapi.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/run")
/** Handles the requests coming from the client and forwards them to the service */
public class RunController {

    private final RunService runService;

    @Autowired
    public RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Run>> getRuns() {
        List<Run> runs = runService.getRuns();
        return new ResponseEntity<>(runs, HttpStatus.OK);
    }

    @GetMapping("/find/{title}")
    public ResponseEntity<Run> getRunByTitle(@PathVariable("title") String title) {
        Run run = runService.findRunByTitle(title);
        return new ResponseEntity<>(run, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Run> registerNewRun(@RequestBody Run run) {
        runService.addNewRun(run);
        return new ResponseEntity<>(HttpStatus.CREATED); // can return run
    }

    @DeleteMapping(path = "/delete/{runId}")
    public ResponseEntity<?> deleteRun(@PathVariable("runId") Long runId) {
        runService.deleteRun(runId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path="/update/{runId}")
    public ResponseEntity<Run> updateRun(@PathVariable("runId") Long runId, @RequestBody Run runDetails){
        runService.updateRun(runId, runDetails);
        return new ResponseEntity<>(HttpStatus.OK); // can return run
    }
}
