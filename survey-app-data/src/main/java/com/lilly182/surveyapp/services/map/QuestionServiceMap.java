package com.lilly182.surveyapp.services.map;

import com.lilly182.surveyapp.model.QuestionAndAnswer;
import com.lilly182.surveyapp.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class QuestionServiceMap extends AbstractMapService<QuestionAndAnswer,Long> implements QuestionService {
    @Override
    public Set<QuestionAndAnswer> findAll() {
        return super.findAll();
    }

    @Override
    public QuestionAndAnswer findById(Long id) {
        return super.findById(id);
    }

    @Override
    public QuestionAndAnswer save(QuestionAndAnswer questionAndAnswer) {
        return super.save(questionAndAnswer);
    }

    @Override
    public void delete(QuestionAndAnswer questionAndAnswer) {
        super.delete(questionAndAnswer);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
