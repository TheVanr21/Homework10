package ru.netology;

public class MoviesManager {
    private Movie[] movies = new Movie[0];

    private int limit = 10;

    public MoviesManager() {
    }

    public MoviesManager(int limit) {
        if (limit < 1) return;
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void add(Movie addedMovie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = addedMovie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int currentLimit = Math.min(limit, movies.length);
        Movie[] result = new Movie[currentLimit];
        int indexForCopy = 0;
        for (int i = 0; i < currentLimit; i++) {
            result[indexForCopy] = movies[movies.length - 1 - i];
            indexForCopy++;
        }
        return result;
    }

}
