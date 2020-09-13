public class OriginalFromPokemonTrainer {
//The Code is Working!!!


    //package E6_PokemonTrainer;
    //
    //import java.io.BufferedReader;
    //import java.io.IOException;
    //import java.io.InputStreamReader;
    //import java.util.*;
    //
    //public class Main {
    //    public static void main(String[] args) throws IOException {
    //        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //
    //        Map<String, Trainer> storeTrainers = new LinkedHashMap<>();
    //
    //        String line;
    //        while (!(line = reader.readLine()).equals("Tournament")) {
    //            String[] tokens = line.split("\\s+");
    //            String nameTrainer = tokens[0];
    //            String namePokemon = tokens[1];
    //            String element = tokens[2];
    //            int health = Integer.parseInt(tokens[3]);
    //
    //            Pokemon pokemon = new Pokemon(namePokemon, element, health);
    //
    //            if (!storeTrainers.containsKey(nameTrainer)) {
    //                Trainer trainer = new Trainer(nameTrainer);
    //                trainer.addPokemon(pokemon);
    //                storeTrainers.put(nameTrainer, trainer);
    //            } else {
    //                for (Map.Entry<String, Trainer> entry : storeTrainers.entrySet()) {
    //                    if (entry.getKey().equals(nameTrainer)) {
    //                        entry.getValue().addPokemon(pokemon);
    //                        break;
    //                    }
    //                }
    //            }
    //        }
    //
    //        while (!(line = reader.readLine()).equals("End")) {
    //            for (Map.Entry<String, Trainer> entry : storeTrainers.entrySet()) {
    //                List<Pokemon> pokemons = entry.getValue().getPokemons();
    //                boolean hasElement = false;
    //                for (Pokemon pokemon : pokemons) {
    //                    if (pokemon.getElement().equalsIgnoreCase(line)) {
    //                        entry.getValue().setBadges(1);
    //                        hasElement = true;
    //                        break;
    //                    }
    //                }
    //                if (!hasElement) {
    //                    decreaseHealth(storeTrainers, entry.getKey());
    //                }
    //            }
    //        }
    //
    //
    //        storeTrainers.entrySet().stream().sorted((a1, a2) -> a2.getValue().getBadges() - a1.getValue().getBadges())
    //                .forEach(k -> {
    //                    System.out.println(k.getKey() + " " + k.getValue().getBadges() + " " + k.getValue().getPokemons().size());
    //                });
    //
    //    }
    //
    //    private static void decreaseHealth(Map<String, Trainer> storeTrainers, String key) {
    //        for (Map.Entry<String, Trainer> entry : storeTrainers.entrySet()) {
    //            if (entry.getKey().equals(key)) {
    //                List<Pokemon> pokemons = entry.getValue().getPokemons();
    //                pokemons.forEach(Pokemon::decreaseHealth);
    //                pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    //
    //            }
    //        }
    //    }
    //}
    //
    //
    //// Iterator<Pokemon> iter = entry.getValue().getPokemons().iterator();
    ////              while(iter.hasNext()){
    ////                  Pokemon poke = iter.next();
    ////                  poke.decreaseHealth();
    ////                  if(poke.isDead()){
    ////                      iter.remove();
    ////                  }
    ////              }
}
