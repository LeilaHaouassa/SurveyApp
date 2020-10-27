package com.lilly182.surveyapp.services.springdatajpa;

import com.lilly182.surveyapp.model.QuestionAndOption;
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

    public QuestionSDJpaService(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Set<QuestionAndOption> findAll() {
        Set<QuestionAndOption> questionAndOptions = new HashSet<>();
        questionRepository.findAll().forEach(questionAndOptions::add);
        return questionAndOptions;
    }

    @Override
    public QuestionAndOption findById(Long aLong) {
        return questionRepository.findById(aLong).orElse(null);
    }

    @Override
    public QuestionAndOption save(QuestionAndOption questionAndOption) {
        if(questionAndOption.getSurvey() != null) {
            return questionRepository.save(questionAndOption);
        }else {
            throw new RuntimeException("Question without Survey!!");
        }
    }

    @Override
    public void delete(QuestionAndOption object) {
        questionRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        questionRepository.deleteById(aLong);
    }
}
