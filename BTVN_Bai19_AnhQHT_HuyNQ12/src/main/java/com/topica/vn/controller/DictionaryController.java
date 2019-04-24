package com.topica.vn.controller;

import com.topica.vn.model.Vietnamese;
import com.topica.vn.repository.VietnameseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class DictionaryController {

    @Autowired
    VietnameseRepository vietnameseRepository;

    @GetMapping("/home")
    public String home(Model model, Principal principal, Vietnamese vietnamese){
        try {
            String userName = principal.getName();
            model.addAttribute("userName", userName);
            } catch (NullPointerException e){
            model.addAttribute("userName", "");
            }
//            model.addAttribute("searchWord", vietnameseRepository.findByContent(vietnamese.getContent()));
        if(vietnamese.getContent() == null){
            model.addAttribute("searchWord",vietnamese);
        } else {
            model.addAttribute("searchWord", vietnameseRepository.findByContent(vietnamese.getContent()));
        }
            model.addAttribute("allVietnamese", vietnameseRepository.findAll());
        return "test";
    }

    //  @RequestMapping(name = "/hello", method = RequestMethod.GET)
    //  public String hello(Model model, Vietnamese vietnamese){
    //      model.addAttribute(vietnamese);
    //      return "hello";
    //  }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(name = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        model.addAttribute("userInfo", userName);

        return "userInfoPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

//    @PostMapping("/search")
//    public String formPost(Model model,@ModelAttribute Vietnamese vietnamese) {
//        model.addAttribute("word", vietnamese);
//        return "index";
//    }
}
