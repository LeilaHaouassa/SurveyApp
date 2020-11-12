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


        Survey survey2 = new Survey();

        survey2.setTitle("Test 2");
        survey2.setDescription("survey for test 2");
        survey2.setCreationDate(new Date());
        survey2.setPostedOn(new Date());
        survey2.setPostedOff(new Date(2020, Calendar.DECEMBER,30));

        QuestionAndOption question21= new QuestionAndOption();

        question21.setQuestionType(QuestionType.SHORT_ANSWER);
        question21.setText("question number 1");
        question21.setSurvey(survey);

        QuestionAndOption question22= new QuestionAndOption();

        question22.setQuestionType(QuestionType.CHECKBOX);
        question22.setText("question number 2");
        question22.setSurvey(survey);

        QuestionAndOption question23= new QuestionAndOption();

        question23.setQuestionType(QuestionType.PARAGRAPH);
        question23.setText("question number 3");
        question23.setSurvey(survey);




        surveyService.save(survey2);
        questionService.save(question21);
        questionService.save(question22);
        questionService.save(question23);




    }
}
