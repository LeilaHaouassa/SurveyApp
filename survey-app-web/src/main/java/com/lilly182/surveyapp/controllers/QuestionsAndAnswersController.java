package com.lilly182.surveyapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionsAndAnswersController {
    @RequestMapping({"","/","/index","/index.html"})
    public String listQuestions(){
        return "questions/index";
    }
}
