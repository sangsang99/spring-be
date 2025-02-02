package com.idol.spring_be.controller.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.idol.spring_be.entity.User;
import com.idol.spring_be.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("defaultUser");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/login");
        modelAndView.addObject("message", "Login Page");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/login");
        modelAndView.addObject("message", "Login Success");
        return modelAndView;
    }
}
