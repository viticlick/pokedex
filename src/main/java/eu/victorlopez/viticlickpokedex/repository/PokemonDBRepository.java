package eu.victorlopez.viticlickpokedex.repository;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.utils.Client;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class PokemonDBRepository {

    private final Map<Integer, Pokemon> db;

    public PokemonDBRepository() {
        db = IntStream.iterate(1, n -> n + 1)
                .limit(151)
                .parallel()
                .mapToObj(Client::getPokemonById)
                .collect(Collectors.toMap(Pokemon::getId, pokemon -> pokemon));
    }

    public Pokemon getById(Integer id) {
        return db.get(id);
    }

    public List<Pokemon> getPokemonList() {
        return db.values()
                .stream()
                .sorted(Comparator.comparing(Pokemon::getId))
                .collect(Collectors.toList());
    }
}
