package models;

import java.io.Serializable;

public class RoleMapping implements Serializable {
    private Actor actor;
    private Movie movie;

    public RoleMapping(){

    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
