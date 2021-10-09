package com.challenge.controllers;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengerController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping
    public List<Challenge> findByAccelerationIdAndUserId(
            @RequestParam(value = "accelerationId") Long accelerationId,
            @RequestParam(value = "userId") Long userId) {
        return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
