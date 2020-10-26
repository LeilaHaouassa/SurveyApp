package com.lilly182.surveyapp.bootstrap;

import com.lilly182.surveyapp.model.QuestionAndOption;
import com.lilly182.surveyapp.model.QuestionType;
import com.lilly182.surveyapp.model.Survey;
import com.lilly182.surveyapp.services.QuestionService;
import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private final SurveyService surveyService ;
    private final QuestionService questionService;

    @Autowired
    public DataLoader(SurveyService surveyService, QuestionService questionService) {
        this.surveyService = surveyService;
        this.questionService = questionService;
    }

    @Override
    public void run(String... args) throws Exception {

        Survey survey = new Survey();

        survey.setTitle("Test");
        survey.setDescription("survey for test");
        survey.setCreationDate(new Date());
        survey.setPostedOn(new Date());
        survey.setPostedOff(new Date(2020, Calendar.OCTOBER,30));

        QuestionAndOption question1= new QuestionAndOption();

        question1.setQuestionType(QuestionType.PARAGRAPH);
        question1.setText("question number 1");
        question1.setSurvey(survey);

        QuestionAndOption question2= new QuestionAndOption();

        question2.setQuestionType(QuestionType.SHORT_ANSWER);
        question2.setText("question number 2");
        question2.setSurvey(survey);

        QuestionAndOption question3= new QuestionAndOption();

        question3.setQuestionType(QuestionType.MULTIPLE_CHOICES);
        question3.setText("question number 3");
        question3.setSurvey(survey);




        surveyService.save(survey);
        questionService.save(question1);
        questionService.save(question2);
        questionService.save(question3);




    }
}
