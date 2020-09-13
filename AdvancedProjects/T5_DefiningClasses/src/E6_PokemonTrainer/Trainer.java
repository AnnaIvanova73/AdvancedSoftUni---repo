package E6_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private List<Pokemon> pokemons;
    private int badges;


    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        badges = 0;
    }


    public String getName() {
        return name;
    }
    public int getBadges() {
        return badges;
    }


    public void setBadges(int badges) {
        this.badges += badges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
}
