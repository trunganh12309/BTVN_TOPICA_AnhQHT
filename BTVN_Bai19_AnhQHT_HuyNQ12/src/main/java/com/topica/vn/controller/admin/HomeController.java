package com.topica.vn.controller.admin;

import com.topica.vn.model.Vietnamese;
import com.topica.vn.repository.VietnameseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {
    @Autowired
    VietnameseRepository vietnameseRepository;

    @GetMapping(value = "/admin/home")
    public String adminHome(){
        return "redirect:/admin/home/1";
    }

    @RequestMapping(value = "/admin/home/{page}")
    public ModelAndView listWordPageByPage(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Vietnamese> vietnamesePage = vietnameseRepository.findAll(pageable);
        int totalPages = vietnamesePage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.addObject("activeList", true);
        modelAndView.addObject("vietnameseList", vietnamesePage.getContent());
        modelAndView.addObject("vietnamesePage", vietnamesePage);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/detail/{id}")
    public ModelAndView wordDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/detail");
        Optional<Vietnamese> v = vietnameseRepository.findById(id);
        modelAndView.addObject("word",v.get());
        return modelAndView;
    }

//    @RequestMapping(value = "admin/edit/{id}")
//    public String wordEdit(@PathVariable("id") Long id, Model model){
////        ModelAndView modelAndView = new ModelAndView("admin/edit");
//        Optional<Vietnamese> v = vietnameseRepository.findById(id);
//        model.addAttribute("word",v.get());
//        vietnameseRepository.save(v.get());
//        return "admin/detail";
//    }
}
