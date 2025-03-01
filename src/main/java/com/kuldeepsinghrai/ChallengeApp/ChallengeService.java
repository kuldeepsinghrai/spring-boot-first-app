package com.kuldeepsinghrai.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeService() {
        Challenge challenge1 = new Challenge(1L, "January", "Learn a New Programming Language");
        challenges.add(challenge1);
    }


    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public boolean addChallenges(Challenge challenge) {
        if (challenge != null) {
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }
}
