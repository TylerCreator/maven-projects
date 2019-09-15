package models;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Director implements Serializable {
    private long id;
    private String fname;
    private String sname;
    private Set<Director> movies = new HashSet<Director>(0);

    public Director(){
    }

    public Set<Director> getMovies() {
        return movies;
    }

    public void setMovies(Set<Director> movies) {
        this.movies = movies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


}
