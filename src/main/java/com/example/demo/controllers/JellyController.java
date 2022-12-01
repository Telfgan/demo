package com.example.demo.controllers;


import com.example.demo.models.Jelly;
import com.example.demo.services.JellyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/jelly")
public class JellyController {

    final JellyService jellyService;

    public JellyController(JellyService jellyService) {
        this.jellyService = jellyService;
    }

    @GetMapping("/")
    public String jellys(@RequestParam(defaultValue = "") String keyword, Model model) {
        if (keyword == "") {
            Iterable<Jelly> jellyIterable = jellyService.findAll();
            model.addAttribute("jellylist", jellyIterable);
        } else {
            List<Jelly> jellyList = jellyService.findByNameContains(keyword);
            model.addAttribute("jellylist", jellyList);
        }
        return "/jelly/jelly";
    }


    @GetMapping("/add")
    public String AddView(Jelly jelly) {
        return "jelly/jelly-add";
    }


    @PostMapping("/add")
    public String AddJelly(@Valid Jelly jelly, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "jelly/jelly-add";
        }

        jellyService.save(jelly);
        return"redirect:/jelly/";
}
    @GetMapping("/jelly-info/{id}")
    public String detailJelly(
            @PathVariable Long id,
            Model model
    ){
        Jelly jelly_obj =jellyService.findById(id).orElseThrow();
        model.addAttribute("one_jelly", jelly_obj);
        return "/jelly/jelly-info";
    }

    @GetMapping("/jelly-info/{id}/upd")
    public String updJelly(@PathVariable Long id, Model model)
    {
        model.addAttribute("object", jellyService.findById(id).orElseThrow());
        return "/jelly/jelly-upd";
    }



    @GetMapping("/jelly-info/{id}/del")
    public String delJelly(@PathVariable Long id) {
        Jelly jelly_obj = jellyService.findById(id).orElseThrow();
        jellyService.delete(jelly_obj);
        return "redirect:/jelly/";
    }

    @PostMapping("/jelly-info/{id}/upd" )
    public String updJellyPost(@PathVariable Long id,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "shape") String shape,
                                @RequestParam(name = "sweetness") String sweetness,
                                @RequestParam(name = "sourness") String sourness,
                                @RequestParam(name = "juice") String juice
    ) {
        Jelly newJelly = jellyService.findById(id).orElseThrow();
        newJelly.setName(name);
        newJelly.setShape(shape);
        newJelly.setSweetness(sweetness);
        newJelly.setSourness(sourness);
        newJelly.setJuice(juice);

        jellyService.save(newJelly);
        return "redirect:/jelly/";
    }
}
