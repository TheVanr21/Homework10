package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MoviesRepository;

public class MoviesManager {
    private MoviesRepository moviesRepository;
    private int limit = 10;

    public MoviesManager(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public MoviesManager(MoviesRepository moviesRepository, int limit) {
        this.moviesRepository = moviesRepository;
        if (limit < 1) return;
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void add(Movie addedMovie) {
        moviesRepository.save(addedMovie);
    }

    public Movie[] findAll() {
        return moviesRepository.findAll();
    }

    public Movie[] findLast() {
        Movie[] movies = findAll();
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
