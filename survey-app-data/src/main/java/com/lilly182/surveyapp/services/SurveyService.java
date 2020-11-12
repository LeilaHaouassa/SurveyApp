package com.lilly182.surveyapp.services;

import com.lilly182.surveyapp.model.Survey;

import java.util.List;

public interface SurveyService extends CrudService<Survey,Long> {


     Iterable<Survey> listForAdmin();

     List<Survey> findAllByTitleLike(String title);


}
