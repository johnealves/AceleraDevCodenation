package com.challenge.controllers;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable("id") Long id) {
        return this.accelerationService.findById(id);
    }

    @GetMapping(params = "companyId")
    public List<Acceleration> findBuCompanyId(@RequestParam Long companyId) {
        return this.accelerationService.findByCompanyId(companyId);
    }

}
