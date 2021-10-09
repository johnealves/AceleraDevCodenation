package com.challenge.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners({
})
@Table(name = "challenge")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @NotNull
    @Column(name = "created_at")
//    @CreationTimestamp
    @CreatedDate
    private Timestamp createdAt;

    @NotNull
    @OneToMany
    private List<Submission> submissions;

    @NotNull
    @OneToMany
    private List<Acceleration> accelerations;
}
