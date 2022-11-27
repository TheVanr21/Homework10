package ru.netology.repository;

import ru.netology.domain.Movie;

public class MoviesRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie addedMovie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = addedMovie;
        movies = tmp;
    }

    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length - 1];
        int indexForCopy = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[indexForCopy] = movie;
                indexForCopy++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new Movie[0];
    }

}
