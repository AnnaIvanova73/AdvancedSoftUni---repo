package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < this.capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        boolean hasName = this.roster.stream().anyMatch(e -> e.getName().equals(name));

        if (hasName) {
            Player player = this.roster.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
            this.roster.remove(player);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        this.roster.stream().filter(e -> e.getName().equals(name)).findFirst().ifPresent(player1 -> player1.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = this.roster.stream().filter(e -> e.getClazz().equals(clazz)).collect(Collectors.toList());
        if (roster.removeAll(kickedPlayers)) {
            Player[] player = new Player[kickedPlayers.size()];
            for (int i = 0; i < kickedPlayers.size(); i++) {
                player[i] = kickedPlayers.get(i);
            }
            return player;
        }
        return null;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder printer = new StringBuilder();
        printer.append(String.format("Players in the guild: %s:%n", this.name));
        this.roster.forEach(e -> printer.append(e.toString()).append(System.lineSeparator()));
        return printer.toString();
    }
}
