package com.lilly182.surveyapp.services.springdatajpa;

import com.lilly182.surveyapp.model.Option;
import com.lilly182.surveyapp.repositories.OptionRepository;
import com.lilly182.surveyapp.repositories.QuestionRepository;
import com.lilly182.surveyapp.services.OptionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class OptionSDJpaService implements OptionService {

    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    public OptionSDJpaService(QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public Set<Option> findAll() {
        Set<Option> options = new HashSet<>();
        optionRepository.findAll().forEach(options::add);
        return options;
    }

    @Override
    public Option findById(Long aLong) {
        return optionRepository.findById(aLong).orElse(null);
    }

    @Override
    public Option save(Option option) {
        if(option.getQuestion() != null) {
            return optionRepository.save(option);
        }else {
            throw new RuntimeException("Option without Question!!");
        }
    }

    @Override
    public void delete(Option object) {
        optionRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        optionRepository.deleteById(aLong);
    }
}
