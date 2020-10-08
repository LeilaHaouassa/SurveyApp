package com.lilly182.surveyapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/surveys")
public class SurveyController {
    @RequestMapping({"/","/index","/index.html"})
    public String listSurveys(){
        return "surveys/index";
    }
}
