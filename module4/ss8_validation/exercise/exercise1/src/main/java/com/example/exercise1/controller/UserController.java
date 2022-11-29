package com.example.exercise1.controller;

import com.example.exercise1.model.User;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<User> userList=iUserService.findAll();
        model.addAttribute("userList",userList);
        return "user/list";
    }
    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/user";
    }
}
