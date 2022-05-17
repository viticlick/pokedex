package eu.victorlopez.viticlickpokedex.controller;

import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.utils.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokedexController {

    @RequestMapping("/")
    public ModelAndView index() {
        NamedAPIResourceList pokemonList = Client.getPokemonList(151, 0);
        return new ModelAndView("index", "pokemons", pokemonList.getResults());
    }

}
