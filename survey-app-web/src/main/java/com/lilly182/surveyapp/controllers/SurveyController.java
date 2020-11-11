package com.lilly182.surveyapp.controllers;

import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping({"","/"})
    public String listSurveys(Model model){
        model.addAttribute("surveys",surveyService.findAll());
        return "surveys/index";
    }

    @GetMapping("/{surveyId}")
    public ModelAndView showOwner(@PathVariable(name = "surveyId") Long surveyId) {
        ModelAndView mav = new ModelAndView("surveys/details");
        mav.addObject(surveyService.findById(surveyId));
        return mav;
    }
}
