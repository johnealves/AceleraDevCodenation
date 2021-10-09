package com.challenge.controllers;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findiById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(this.userService.findById(id)
                .orElseThrow(RuntimeException::new), HttpStatus.OK);
    }

    @GetMapping(params = "accelerationName")
    public List<User> findByAccelerationName(@RequestParam String accelerationName) {
        return this.userService.findByAccelerationName(accelerationName);
    }

    @GetMapping(params = "companyId")
    public List<User> findByCompanyId(@RequestParam Long companyId) {
        return this.userService.findByCompanyId(companyId);
    }
}
