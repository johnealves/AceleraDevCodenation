package com.challenge;

import com.challenge.controllers.CandidateController;
import com.challenge.entity.Candidate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringHttpApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringHttpApplication.class, args);
    }

}
