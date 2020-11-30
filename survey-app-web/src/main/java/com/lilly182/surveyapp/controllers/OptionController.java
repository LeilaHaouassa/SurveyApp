package com.lilly182.surveyapp.controllers;


import com.lilly182.surveyapp.model.Option;
import com.lilly182.surveyapp.model.Question;
import com.lilly182.surveyapp.services.OptionService;
import com.lilly182.surveyapp.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/surveys/{surveyId}/questions/{questionId}/options")
public class OptionController {
    private final QuestionService questionService;
    private final OptionService optionService;

    public OptionController(QuestionService questionService, OptionService optionService) {
        this.questionService = questionService;
        this.optionService = optionService;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

//        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) throws IllegalArgumentException{
//                setValue(LocalDate.parse(text));
//            }
//        });
    }

    @ModelAttribute("option")
    public Option loadQuestionWithOption(@PathVariable("questionId") Long questionId, Map<String, Object> model) {
        Question question = questionService.findById(questionId);
        model.put("question", question);
        Option option = new Option();
        question.getOptions().add(option);
        option.setQuestion(question);
        return option;
    }


    // Spring MVC calls method loadQuestionWithOption(...) before initNewOptionForm is called
    @GetMapping("/new")
    public String initNewOptionForm(@PathVariable("questionId") Long questionId, Map<String, Object> model) {
        return "questions/createOrUpdateOption";
    }

    // Spring MVC calls method loadQuestionWithOption(...) before processNewOptionForm is called
    @PostMapping("/new")
    public String processNewOptionForm(@Valid Option option, BindingResult result) {
        if (result.hasErrors()) {
            return "questions/createOrUpdateOption";
        } else {
            optionService.save(option);

            return "redirect:/surveys/{surveyId}";
        }
    }


}
