package model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private String director;
    private String genre;

    public Movie(String a, String b, String c) {
        this.name = a;
        this.director = b;
        this.genre = c;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
