package com.lilly182.surveyapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter


@Table(name = "questions")
public class Question extends BaseEntity{

    @Builder
    public Question(String text, QuestionType questionType, Survey survey, Set<Option> options) {
        this.text = text;
        this.questionType = questionType;
        this.survey = survey;
        if(options != null || options.size() > 0){
            this.options = options;
        }
    }

    public Question() {
    }

    @Column(name = "text")
    private String text;
    @Column(name = "question_type")
    @Enumerated(value = EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "question")
    private Set<Option> options =  new HashSet<>();



}