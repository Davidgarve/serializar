package model;

import java.io.Serializable;

public class Session implements Serializable {
    private Movie movie;
    private Theater theater;

    public Session(Movie a, Theater b){
        this.movie = a;
        this.theater = b;
    }

    @Override
    public String toString() {
        return this.movie + " ," + this.theater;
    }
}
