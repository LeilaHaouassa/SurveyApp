package com.lilly182.surveyapp.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
