package com.lilly182.surveyapp.repositories;

import com.lilly182.surveyapp.model.QuestionAndOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionAndOption,Long> {
}
