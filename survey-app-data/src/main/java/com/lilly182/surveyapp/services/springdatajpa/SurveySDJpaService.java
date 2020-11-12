package com.lilly182.surveyapp.services.springdatajpa;

import com.lilly182.surveyapp.model.Survey;
import com.lilly182.surveyapp.repositories.QuestionRepository;
import com.lilly182.surveyapp.repositories.SurveyRepository;
import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SurveySDJpaService implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;

    public SurveySDJpaService(SurveyRepository surveyRepository, QuestionRepository questionRepository) {
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Iterable<Survey> listForAdmin() {
        return surveyRepository.findAll();
    }

    @Override
    public List<Survey> findAllByTitleLike(String title) {
        return surveyRepository.findAllByTitleLike(title);
    }

    //to modify in a way that it delivers the only posted quiz
    @Override
    public Set<Survey> findAll() {
        Set<Survey> surveys = new HashSet<>();
        surveyRepository.findAll().forEach(surveys::add);
        return surveys;
    }

    @Override
    public Survey findById(Long aLong) {
        return surveyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Survey save(Survey object) {
        return surveyRepository.save(object);
    }

    @Override
    public void delete(Survey object) {
        surveyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        surveyRepository.deleteById(aLong);
    }
}
