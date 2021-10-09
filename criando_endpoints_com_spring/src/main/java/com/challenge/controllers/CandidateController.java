package com.challenge.controllers;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public Optional<Candidate> findById(
            @PathVariable("userId") Long userId,
            @PathVariable("companyId") Long companyId,
            @PathVariable("accelerationId") Long accelerationId
    ) {
        return this.candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping(params = "companyId")
    public List<Candidate> findByCompanyId(@RequestParam Long companyId) {
        return this.candidateService.findByCompanyId(companyId);
    }

    @GetMapping(params = "accelerationId")
    public List<Candidate> findByAccelerationId(@RequestParam Long accelerationId) {
        return this.candidateService.findByCompanyId(accelerationId);
    }
}
