package com.example.exercise2.controller;

import com.example.exercise2.model.Song;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("")
    public String showList(Model model){
        Iterable<Song> songList=iSongService.findAll();
        model.addAttribute("songList",songList);
        return "song/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("song",new Song());
        return "song/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/song";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Song song=iSongService.findById(id).get();
        model.addAttribute("song",song);
        return "song/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess","Sửa thành công");
        return "redirect:/song";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id,Model model){
        Song song=iSongService.findById(id).get();
        model.addAttribute("song",song);
        return "song/view";
    }
}
