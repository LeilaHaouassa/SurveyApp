package com.lilly182.surveyapp.controllers;

import com.lilly182.surveyapp.model.Survey;
import com.lilly182.surveyapp.services.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

//    @RequestMapping({"","/","/index"})
//    public String listSurveys(Model model){
//        model.addAttribute("surveys",surveyService.findAll());
//        return "surveys/index";
//    }

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

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String processFindForm(Survey survey, BindingResult result, Model model) {
        // allow parameterless GET request for /surveys to return all records
        if (survey.getTitle() == null) {
            survey.setTitle(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Survey> results = surveyService.findAllByTitleLike("%" + survey.getTitle()+ "%");
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("title", "notFound", "not found");
            return "surveys/find";
        }
        else if (results.size() == 1) {
            // 1 owner found
            survey = results.get(0);
            return "redirect:/surveys/" + survey.getId().toString();
        }
        else {
            // multiple owners found
            model.addAttribute("surveys", results);
            return "surveys/index";
        }
    }


}
