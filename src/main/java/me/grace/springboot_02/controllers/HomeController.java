package me.grace.springboot_02.controllers;


import me.grace.springboot_02.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/indexprocessform")
    public String indexconf(@RequestParam("login") String login, Model model){
        model.addAttribute("loginval", login);
        return "indexconfirm";
    }

    @RequestMapping("/lesson2")
    public String homePage(Model model)
    {
        model.addAttribute("myvar", "say hello to the people");
        return "lesson2";
    }

    @RequestMapping("/lesson3")
    public String lesson3(){
        return "lesson3";
    }

    @RequestMapping("/l4loadform")
    public String lesson4post(){
        return "l4formtemplate";
    }

    @RequestMapping("/l4processform")
    public String lesson4get(@RequestParam("login") String login, Model model){
        model.addAttribute("loginval", login);
        return "l4confirm";
    }

    @PostMapping("/songform")
    public String loadformPage(Model model)
    {
        model.addAttribute("Song", new Song());
        return "songform";
    }


    @GetMapping("/songform")
    public String loadFromPage(@Valid @ModelAttribute Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "songform";
        }

        return "confirmsong";
    }


}