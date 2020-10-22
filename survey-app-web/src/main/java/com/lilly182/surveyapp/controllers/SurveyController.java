package com.lilly182.surveyapp.controllers;

import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listSurveys(Model model){
        model.addAttribute("surveys",surveyService.findAll());
        return "surveys/index";
    }
}
