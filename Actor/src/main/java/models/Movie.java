package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Movie implements Serializable {
    private long id;
    private String name;
    private long year;
    private float rank;
    private Set<Director> directors = new HashSet<Director>(0);
    private Set<Actor> roles = new HashSet<Actor>(0);

    public Set<Actor> getRoles() {
        return roles;
    }

    public void setRoles(Set<Actor> roles) {
        this.roles = roles;
    }

    public Movie(){

    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

}
