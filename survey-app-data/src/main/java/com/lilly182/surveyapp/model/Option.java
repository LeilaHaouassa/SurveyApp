package com.lilly182.surveyapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter

public class Option extends BaseEntity {

    private String content;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
