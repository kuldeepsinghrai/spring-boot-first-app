package com.kuldeepsinghrai.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;
    
    public ChallengeService() {
    }


    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public boolean addChallenges(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }
}
