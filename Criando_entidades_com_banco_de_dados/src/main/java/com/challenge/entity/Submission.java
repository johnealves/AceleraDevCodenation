package com.challenge.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@EntityListeners({
})
@Table(name = "submission")
public class Submission {

    @EmbeddedId
    @NotNull
    private UserChallenge userChallenge;

    @NotNull
    private Float score;

    @NotNull
    @Column(name = "created_at")
    @CreatedDate
    private Timestamp createdAt;
}
