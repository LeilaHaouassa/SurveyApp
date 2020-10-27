package com.lilly182.surveyapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
public class QuestionAndOption extends BaseEntity{
    @Column(name = "text")
    private String text;
    @Column(name = "question_type")
    @Enumerated(value = EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
    @ElementCollection
    private Set<String> options =  new HashSet<>();



}