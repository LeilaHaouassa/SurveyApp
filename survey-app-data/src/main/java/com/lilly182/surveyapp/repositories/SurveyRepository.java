package com.lilly182.surveyapp.repositories;

import com.lilly182.surveyapp.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey,Long> {
    List<Survey> findAllByTitleLike(String title);
}
