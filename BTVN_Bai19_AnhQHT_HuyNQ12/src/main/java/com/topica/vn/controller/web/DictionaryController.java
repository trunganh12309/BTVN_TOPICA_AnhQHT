package com.topica.vn.controller.web;

import com.topica.vn.model.Vietnamese;
import com.topica.vn.repository.VietnameseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller(value = "dictController")
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
        if(vietnamese.getContent() == null){
            model.addAttribute("searchWord",vietnamese);
        } else {
            if(vietnameseRepository.findByContent(vietnamese.getContent()) != null){
                model.addAttribute("searchWord", vietnameseRepository.findByContent(vietnamese.getContent()));
            }else{
                model.addAttribute("searchWord",new Vietnamese(vietnamese.getContent(),"Không tìm thấy từ!!!"));
            }
        }
            model.addAttribute("allVietnamese", vietnameseRepository.findAll());
        return "test";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(name="/logout", method=RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }
}
