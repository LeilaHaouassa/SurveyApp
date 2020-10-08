package com.lilly182.surveyapp.services.map;

import com.lilly182.surveyapp.model.Survey;
import com.lilly182.surveyapp.services.CrudService;

import java.util.Set;

public class SurveyServiceMap extends AbstractMapService<Survey,Long> implements CrudService<Survey,Long> {
    @Override
    public Set<Survey> findAll() {
        return super.findAll();
    }

    @Override
    public Survey findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Survey save(Survey survey) {
        return super.save(survey.getId(),survey);
    }

    @Override
    public void delete(Survey survey) {
        super.delete(survey);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
