package com.wizian.admission.wizianb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("hello","하이헬로우 안녕");
        return "/index";
    }

    @GetMapping("/side")
    public String side(){return "/admin/side";}
    @GetMapping("/test")
    public String test(){
        return "/admin/nthMozip";
    }

    @GetMapping("/nth")
    public String nth(){
        return "/admin/nthInfo";
    }

    @GetMapping("/notice")
    public String notice(){ return "/admin/nthNotice";}

    @GetMapping("/monhang")
    public String monhang(){
        return "/admin/nthMonhang";
    }

    @GetMapping("/apply")
    public String applyForm() { return "/application/application_edu";}


    @GetMapping("/apply1")
    public String apply() { return "/admin/nthApply";}

}
