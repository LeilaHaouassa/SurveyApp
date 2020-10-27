package com.lilly182.surveyapp.services.map;

import com.lilly182.surveyapp.model.Survey;
import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SurveyServiceMap extends AbstractMapService<Survey,Long> implements SurveyService {
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
        return super.save(survey);
    }

    @Override
    public void delete(Survey survey) {
        super.delete(survey);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Iterable<Survey> listForAdmin() {
        return null;
    }
}
