package com.codegym.controllers;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String showFormCreateUser(Model model) {
//        model.addAttribute("user", new User());
//        return "index";
//    }
    @GetMapping("/")
public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
//    @PostMapping("/")
//    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasFieldErrors()) {
//            return "index";
//        }
//        userService.save(user);
//        model.addAttribute("user", user);
//        return "result";
//    }
    @PostMapping("/")
    public ModelAndView creatUser(@Validated @ModelAttribute("user")User user,BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user",new User());
        modelAndView.addObject("message","add User success!!");
        return modelAndView;
    }
}
