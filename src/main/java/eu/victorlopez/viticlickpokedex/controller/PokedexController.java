package eu.victorlopez.viticlickpokedex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PokedexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
