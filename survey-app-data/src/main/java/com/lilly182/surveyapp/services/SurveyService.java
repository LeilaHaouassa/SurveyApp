package com.lilly182.surveyapp.services;

import com.lilly182.surveyapp.model.Survey;

public interface SurveyService extends CrudService<Survey,Long> {


    Iterable<Survey> listForAdmin();


}
