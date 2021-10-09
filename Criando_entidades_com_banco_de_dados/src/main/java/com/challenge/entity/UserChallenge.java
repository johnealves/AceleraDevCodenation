package com.challenge.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class UserChallenge implements Serializable {
    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Challenge challenge;

}
