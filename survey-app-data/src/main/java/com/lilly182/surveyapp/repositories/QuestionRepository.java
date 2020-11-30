package com.lilly182.surveyapp.repositories;

import com.lilly182.surveyapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
