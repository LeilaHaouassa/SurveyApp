package com.lilly182.surveyapp.services.map;

import com.lilly182.surveyapp.model.QuestionAndAnswer;
import com.lilly182.surveyapp.services.CrudService;

import java.util.Set;

public class QuestionAndAnswerMap extends AbstractMapService<QuestionAndAnswer,Long> implements CrudService<QuestionAndAnswer,Long> {
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
        return super.save(questionAndAnswer.getId(),questionAndAnswer);
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
