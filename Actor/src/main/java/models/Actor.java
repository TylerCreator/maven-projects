package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Actor implements Serializable {
    private long id;
    private String first_name;
    private String last_name;
    private char gender;
    private Set<Movie> movies = new HashSet<Movie>(0);



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }



    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Actor(){

    }


}
