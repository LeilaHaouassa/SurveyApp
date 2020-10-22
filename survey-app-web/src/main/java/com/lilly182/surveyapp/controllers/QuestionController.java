package com.lilly182.surveyapp.controllers;

import com.lilly182.surveyapp.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listQuestions(Model model){
        model.addAttribute("questions",questionService.findAll());
        return "questions/index";
    }
}
