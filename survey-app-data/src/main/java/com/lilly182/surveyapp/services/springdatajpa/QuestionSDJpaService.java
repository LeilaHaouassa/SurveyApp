package com.lilly182.surveyapp.services.springdatajpa;

import com.lilly182.surveyapp.model.Question;
import com.lilly182.surveyapp.repositories.OptionRepository;
import com.lilly182.surveyapp.repositories.QuestionRepository;
import com.lilly182.surveyapp.repositories.SurveyRepository;
import com.lilly182.surveyapp.services.QuestionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class QuestionSDJpaService implements QuestionService {

    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    public QuestionSDJpaService(SurveyRepository surveyRepository, QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public Set<Question> findAll() {
        Set<Question> questions = new HashSet<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

    @Override
    public Question findById(Long aLong) {
        return questionRepository.findById(aLong).orElse(null);
    }

    @Override
    public Question save(Question question) {
        if(question.getSurvey() != null) {
            return questionRepository.save(question);
        }else {
            throw new RuntimeException("Question without Survey!!");
        }
    }

    @Override
    public void delete(Question object) {
        questionRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        questionRepository.deleteById(aLong);
    }
}
