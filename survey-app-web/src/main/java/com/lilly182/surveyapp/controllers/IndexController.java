package com.lilly182.surveyapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"","/","index","index.html"})
    public String index(){

        //System.out.println("welcome 123 jqgdiufh");
        return "index";
    }
}
