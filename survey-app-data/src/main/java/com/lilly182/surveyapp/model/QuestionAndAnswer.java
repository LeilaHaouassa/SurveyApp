package com.lilly182.surveyapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
@Getter
@Setter
public class QuestionAndAnswer extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String text;
    @Enumerated(value = EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
    @ElementCollection
    private Set<String> answers =  new HashSet<>();



}