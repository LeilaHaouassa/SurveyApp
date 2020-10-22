package com.lilly182.surveyapp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Entity
@Getter
@Setter
public class Survey extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private String title;
    @CreationTimestamp
    private Date creationDate ;
    @Temporal( TemporalType.DATE)
    private Date postedOn ;
    @Temporal( TemporalType.DATE)
    private Date postedOff ;

    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
    private Set<QuestionAndAnswer> questions = new HashSet<>();


}