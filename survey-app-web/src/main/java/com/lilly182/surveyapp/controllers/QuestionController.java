package com.lilly182.surveyapp.controllers;

import com.lilly182.surveyapp.model.Question;
import com.lilly182.surveyapp.model.Survey;
import com.lilly182.surveyapp.services.QuestionService;
import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/surveys/{surveyId}")
public class QuestionController {

    private static final String VIEWS_QUESTION_CREATE_OR_UPDATE_FORM = "questions/createOrUpdate";
    private final QuestionService questionService;
    private final SurveyService surveyService;

    public QuestionController(QuestionService questionService, SurveyService surveyService) {
        this.questionService = questionService;
        this.surveyService = surveyService;
    }

    @RequestMapping({"","/"})
    public String listQuestions(Model model){
        model.addAttribute("questions",questionService.findAll());
        return "questions/index";
    }



    @ModelAttribute("survey")
    public Survey findSurvey(@PathVariable("surveyId") Long surveyId) {
        return surveyService.findById(surveyId);
    }

    @InitBinder("survey")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/questions/new")
    public String initCreationForm(Survey survey, Model model) {
        Question question = new Question();
        survey.getQuestions().add(question);
        question.setSurvey(survey);
        model.addAttribute("question", question);
        return VIEWS_QUESTION_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/questions/new")
    public String processCreationForm(Survey survey, @Valid Question question, BindingResult result, Model model) {

        if (StringUtils.hasLength(question.getText()) && question.isNew() && survey.getQuestion(question.getText(), true) != null) {
            result.rejectValue("text", "duplicate", "already exists");
        }
        survey.getQuestions().add(question);
        question.setSurvey(survey);
        if (result.hasErrors()) {
            question.setSurvey(survey);
            model.addAttribute("question", question);
            return VIEWS_QUESTION_CREATE_OR_UPDATE_FORM;
        }
        else {
            questionService.save(question);
            return "redirect:/surveys/" + survey.getId();
        }
    }

    @GetMapping("/questions/{questionId}/edit")
    public String initUpdateForm(@PathVariable Long questionId, Model model) {
        model.addAttribute("question", questionService.findById(questionId));
        return VIEWS_QUESTION_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/questions/{questionId}/edit")
    public String processUpdateForm(@Valid Question question, BindingResult result, Survey survey, Model model) {
        question.setSurvey(survey);
        if (result.hasErrors()) {

            model.addAttribute("question", question);
            return VIEWS_QUESTION_CREATE_OR_UPDATE_FORM;
        }
        else {
            survey.getQuestions().add(question);
            questionService.save(question);
            return "redirect:/surveys/" + survey.getId();
        }
    }



}
