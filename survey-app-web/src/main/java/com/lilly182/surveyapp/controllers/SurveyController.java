package com.lilly182.surveyapp.controllers;

import com.lilly182.surveyapp.model.Survey;
import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;
    private static final String VIEWS_SURVEY_CREATE_OR_UPDATE_FORM = "surveys/createOrUpdate";

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }



    @GetMapping("/{surveyId}")
    public ModelAndView showOwner(@PathVariable(name = "surveyId") Long surveyId) {
        ModelAndView mav = new ModelAndView("surveys/details");
        mav.addObject(surveyService.findById(surveyId));
        return mav;
    }



    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findSurveys(Model model){
        model.addAttribute("survey", Survey.builder().build());
        return "surveys/find";
    }

    @GetMapping({"","/"})
    public String processFindForm(Survey survey, BindingResult result, Model model) {
        // allow parameterless GET request for /surveys to return all records
        if (survey.getTitle() == null) {
            survey.setTitle(""); // empty string signifies broadest possible search
        }

        // find surveyss by last name
        List<Survey> results = surveyService.findAllByTitleLike("%" + survey.getTitle()+ "%");
        if (results.isEmpty()) {
            // no surveys found
            result.rejectValue("title", "notFound", "not found");
            return "surveys/find";
        }
        else if (results.size() == 1) {
            // 1 survey found
            survey = results.get(0);
            return "redirect:/surveys/" + survey.getId().toString();
        }
        else {
            // multiple surveys found
            model.addAttribute("surveys", results);
            return "surveys/index";
        }
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("survey", Survey.builder().build());
        return VIEWS_SURVEY_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Survey survey, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_SURVEY_CREATE_OR_UPDATE_FORM;
        }
        else {
            Survey savedSurvey =surveyService.save(survey);
            return "redirect:/surveys/" + savedSurvey.getId().toString();
        }
    }

    @GetMapping("/{surveyId}/edit")
    public String initUpdateSurveyForm(@PathVariable Long surveyId, Model model) {

        model.addAttribute(surveyService.findById(surveyId));
        return VIEWS_SURVEY_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{surveyId}/edit")
    public String processUpdateSurveyForm(@Valid Survey survey, BindingResult result,
                                         @PathVariable Long surveyId) {
        if (result.hasErrors()) {
            return VIEWS_SURVEY_CREATE_OR_UPDATE_FORM;
        }
        else {
            survey.setId(surveyId);
            Survey savedSurvey = surveyService.save(survey);
            return "redirect:/surveys/" + savedSurvey.getId().toString();
        }
    }



}
