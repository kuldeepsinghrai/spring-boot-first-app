package com.kuldeepsinghrai.ChallengeApp;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }


    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenges(challenge);

        if (isChallengeAdded) {
            return new ResponseEntity<>("Challenge created successfully",HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Challenge not created",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallengeByMonth(@PathVariable String month) {

        Challenge challenge = challengeService.getChallengeByMonth(month);

        if (challenge!=null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated = challengeService.updateChallenge(id,updatedChallenge);
        if (isChallengeUpdated) {
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Challenge not updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if (isChallengeDeleted) {
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge not deleted",HttpStatus.NOT_FOUND);
        }
    }

}
