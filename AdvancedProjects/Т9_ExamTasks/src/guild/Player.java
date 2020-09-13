package guild;

public class Player {

    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.setName(name);
        this.setClazz(clazz);
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return this.clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override

    public String toString (){
        String perPrint =  String.format("Player %s: %s%nRank: %s%n" +
                "Description: %s",this.getName(),this.getClazz(),this.getRank(),this.getDescription());
        return perPrint.trim();
    }
}
