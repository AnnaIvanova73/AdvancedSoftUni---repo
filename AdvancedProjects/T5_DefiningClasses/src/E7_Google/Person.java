package E7_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.car = null;
    }

    public String getName() {
        return this.name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public List<Parents> getParentsList() {
        return this.parentsList;
    }

    public void addParent(Parents parent) {
        this.parentsList.add(parent);
    }

    public List<Children> getChildrenList() {
        return this.childrenList;
    }

    public void addChild(Children children) {
        this.childrenList.add(children);
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
