package com.kuldeepsinghrai.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    private List<Challenge> challenges = new ArrayList<>();

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        challenges.clear();
        challenges.add(new Challenge(1L,"Jan","This is Challenge Description"));
        return challenges;
    }


}
