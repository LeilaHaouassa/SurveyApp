package com.lilly182.surveyapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter



@Table(name = "surveys")
public class Survey extends BaseEntity{
    @Column(name = "title")
    private String title;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "creation_date")
    private final Date creationDate ;
    @Temporal( TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "postedOn")
    private Date postedOn ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal( TemporalType.DATE)
    @Column(name = "postedOff")
    private Date postedOff ;
    @Lob
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "survey")
    private Set<Question> questions = new HashSet<>();

    public Survey() {
        creationDate = new Date();
    }
    @Builder
    public Survey(String title,  Date postedOn, Date postedOff, String description, Set<Question> questions) {
        this.title = title;
        this.creationDate = new Date();
        this.postedOn = postedOn;
        this.postedOff = postedOff;
        this.description = description;
        if(questions != null){
            this.questions = questions;
        }
    }

    /**
     * Return the Question with the given text, or null if none found for this Survey.
     * @param text to test
     * @return true if question text is already in use
     */
    public Question getQuestion(String text) {
        return getQuestion(text, false);
    }

    /**
     * Return the Question with the given text, or null if none found for this Survey.
     * @param text to test
     * @return true if question text is already in use
     */
    public Question getQuestion(String text, boolean ignoreNew) {
        text = text.toLowerCase();
        for (Question question : questions) {
            if (!ignoreNew || !question.isNew()) {
                String compText = question.getText();
                compText = compText.toLowerCase();
                if (compText.equals(text)) {
                    return question;
                }
            }
        }
        return null;
    }
}