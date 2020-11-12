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
@Builder


@Table(name = "surveys")
public class Survey extends BaseEntity{
    @Column(name = "title")
    private String title;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "creation_date")
    private Date creationDate ;
    @Temporal( TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "postedOn")
    private Date postedOn ;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "postedOff")
    private Date postedOff ;
    @Lob
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
    private Set<QuestionAndOption> questions = new HashSet<>();

    public Survey() {
    }

    public Survey(String title, Date creationDate, Date postedOn, Date postedOff, String description, Set<QuestionAndOption> questions) {
        this.title = title;
        this.creationDate = creationDate;
        this.postedOn = postedOn;
        this.postedOff = postedOff;
        this.description = description;
        this.questions = questions;
    }
}