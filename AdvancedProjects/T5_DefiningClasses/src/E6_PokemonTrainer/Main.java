package E6_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Trainer> storeTrainers = new LinkedHashSet<>();
        Set<String> names = new HashSet<>();

        String line;
        while (!(line = reader.readLine()).equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            String nameTrainer = tokens[0];
            String namePokemon = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(namePokemon, element, health);

            if (!names.contains(nameTrainer)) {
                Trainer trainer = new Trainer(nameTrainer);
                trainer.addPokemon(pokemon);
                storeTrainers.add(trainer);
                names.add(nameTrainer);
            } else {
                for (Trainer strTrainer : storeTrainers) {
                    if (strTrainer.getName().equals(nameTrainer)) {
                        strTrainer.addPokemon(pokemon);
                        break;
                    }
                }
            }
        }

        while (!(line = reader.readLine()).equals("End")) {

            for (Trainer trainer : storeTrainers) {
                List<Pokemon> pokemons = trainer.getPokemons();
                String element = line;
                boolean hasElement = pokemons.stream().anyMatch(a -> a.getElement().equals(element));
                if (hasElement) {
                    trainer.setBadges(1);
                } else {
                    decreaseHealth(trainer);
                }
            }

        }

        storeTrainers.stream().sorted((a1, a2) -> a2.getBadges() - a1.getBadges()).forEach(k -> {
            System.out.println(k.getName() + " " + k.getBadges() + " " + k.getPokemons().size());
        });
    }

    private static void decreaseHealth(Trainer strTrainer) {
        List<Pokemon> pokemons = strTrainer.getPokemons();
        pokemons.forEach(Pokemon::decreaseHealth);
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }
}


