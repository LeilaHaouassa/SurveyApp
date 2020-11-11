package com.lilly182.surveyapp.model;

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
}