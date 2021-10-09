package com.challenge.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@EntityListeners({
})
@Table(name = "candidate")
public class Candidate {

    @EmbeddedId
    @NotNull
    private UserAccelerationCompany userAccelerationCompany;

    @NotNull
    private Integer status;

    @NotNull
    @Column(name = "created_at")
    @CreatedDate
    private Timestamp createdAt;
}
