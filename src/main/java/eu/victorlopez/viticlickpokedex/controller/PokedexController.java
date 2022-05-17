package eu.victorlopez.viticlickpokedex.controller;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import eu.victorlopez.viticlickpokedex.repository.PokemonDBRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PokedexController {

    private final PokemonDBRepository repository;

    public PokedexController(PokemonDBRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        List<Pokemon> pokemonList = repository.getPokemonList();
        return new ModelAndView("index", "pokemons", pokemonList);
    }

}
