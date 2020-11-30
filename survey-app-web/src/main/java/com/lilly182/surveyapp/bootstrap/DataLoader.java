package com.lilly182.surveyapp.bootstrap;

import com.lilly182.surveyapp.model.Question;
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

        Calendar cal = Calendar.getInstance();

        Survey survey = new Survey();

        survey.setTitle("Test");
        survey.setDescription("survey for test");
        //survey.setCreationDate(new Date());
        survey.setPostedOn(new Date());

        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        Date datePostedOff = cal.getTime();
        survey.setPostedOff(datePostedOff);

        Question question1= new Question();

        question1.setQuestionType(QuestionType.PARAGRAPH);
        question1.setText("question number 1");
        question1.setSurvey(survey);

        Question question2= new Question();

        question2.setQuestionType(QuestionType.SHORT_ANSWER);
        question2.setText("question number 2");
        question2.setSurvey(survey);

        Question question3= new Question();

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

        survey2.setPostedOn(new Date());

        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 29);
        Date datePostedOff2 = cal.getTime();
        survey2.setPostedOff(datePostedOff2);


        Question question21= new Question();

        question21.setQuestionType(QuestionType.SHORT_ANSWER);
        question21.setText("question number 1");
        question21.setSurvey(survey2);

        Question question22= new Question();

        question22.setQuestionType(QuestionType.CHECKBOX);
        question22.setText("question number 2");
        question22.setSurvey(survey2);

        Question question23= new Question();

        question23.setQuestionType(QuestionType.PARAGRAPH);
        question23.setText("question number 3");
        question23.setSurvey(survey2);




        surveyService.save(survey2);
        questionService.save(question21);
        questionService.save(question22);
        questionService.save(question23);




    }
}
