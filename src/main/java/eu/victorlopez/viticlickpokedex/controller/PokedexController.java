package eu.victorlopez.viticlickpokedex.controller;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import eu.victorlopez.viticlickpokedex.repository.PokemonDBRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
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

    @RequestMapping("/pokemon/{id}")
    public ModelAndView pokemon(@PathVariable("id") Integer id) {
        Pokemon pokemon = repository.getById(id);
        if (pokemon == null) {
            return new ModelAndView("404", HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("pokemon", "pokemon", pokemon);
    }

}
