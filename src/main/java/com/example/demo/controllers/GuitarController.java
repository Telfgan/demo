package com.example.demo.controllers;


import com.example.demo.models.Guitar;
import com.example.demo.models.Jelly;
import com.example.demo.services.GuitarService;
import com.example.demo.services.JellyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/guitar")
public class GuitarController {

    final GuitarService guitarService;

    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping("/")
    public String guitars(@RequestParam(defaultValue = "") String keyword, Model model) {
        if (keyword == "") {
            Iterable<Guitar> guitarIterable = guitarService.findAll();
            model.addAttribute("guitarlist", guitarIterable);
        } else {
            List<Guitar> guitarList = guitarService.findByNameContains(keyword);
            model.addAttribute("guitarlist", guitarList);
        }
        return "/guitar/guitar";
    }


    @GetMapping("/add")
    public String AddView(Guitar guitar) {
        return "guitar/guitar-add";
    }


    @PostMapping("/add")
    public String AddGuitar(@Valid Guitar guitar, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "guitar/guitar-add";
        }

        guitarService.save(guitar);
        return"redirect:/guitar/";
    }
    @GetMapping("/guitar-info/{id}")
    public String detailGuitar(
            @PathVariable Long id,
            Model model
    ){
        Guitar guitar_obj =guitarService.findById(id).orElseThrow();
        model.addAttribute("one_guitar", guitar_obj);
        return "/guitar/guitar-info";
    }

    @GetMapping("/guitar-info/{id}/upd")
    public String updGuitar(@PathVariable Long id, Model model)
    {
        model.addAttribute("object", guitarService.findById(id).orElseThrow());
        return "/guitar/guitar-upd";
    }



    @GetMapping("/guitar-info/{id}/del")
    public String delGuitar(@PathVariable Long id) {
        Guitar guitar_obj = guitarService.findById(id).orElseThrow();
        guitarService.delete(guitar_obj);
        return "redirect:/guitar/";
    }

    @PostMapping("/guitar-info/{id}/upd" )
    public String updGuitarPost(@PathVariable Long id,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "strings") Integer strings,
                               @RequestParam(name = "menzure") Double menzure,
                               @RequestParam(name = "drop") String drop,
                               @RequestParam(name = "cost") Integer cost
    ) {
        Guitar newGuitar = guitarService.findById(id).orElseThrow();
        newGuitar.setName(name);
        newGuitar.setStrings(strings);
        newGuitar.setMenzure(menzure);
        newGuitar.setDrop(drop);
        newGuitar.setCost(cost);

        guitarService.save(newGuitar);
        return "redirect:/guitar/";
    }
}
