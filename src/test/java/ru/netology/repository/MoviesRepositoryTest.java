package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

public class MoviesRepositoryTest {
    Movie movie1 = new Movie(1, "Leon", 1994);
    Movie movie2 = new Movie(2, "Terminator 2: Judgment Day", 1991);
    Movie movie3 = new Movie(3, "Predator", 1987);
    Movie movie4 = new Movie(4, "Die Hard", 1988);
    Movie movie5 = new Movie(5, "Raiders of the Lost Ark", 1981);
    Movie movie6 = new Movie(6, "Enter the Dragon", 1973);
    Movie movie7 = new Movie(7, "Aliens", 1986);
    Movie movie8 = new Movie(8, "The Matrix", 1999);
    Movie movie9 = new Movie(9, "RoboCop", 1987);
    Movie movie10 = new Movie(10, "First Blood", 1982);
    Movie movie11 = new Movie(11, "Kill Bill: Vol. 1", 2003);
    Movie movie12 = new Movie(12, "The Bourne Identity", 2002);

    MoviesRepository moviesRepository = new MoviesRepository();

    @BeforeEach
    public void setup() {
        moviesRepository.save(movie1);
        moviesRepository.save(movie2);
        moviesRepository.save(movie3);
        moviesRepository.save(movie4);
        moviesRepository.save(movie5);
    }

    @Test
    public void shouldSave() {
        moviesRepository.save(movie6);

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6};
        Movie[] actual = moviesRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Movie expected = movie4;
        Movie actual = moviesRepository.findById(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {
        Movie expected = null;
        Movie actual = moviesRepository.findById(7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        moviesRepository.removeById(3);

        Movie[] expected = {movie1, movie2, movie4, movie5};
        Movie[] actual = moviesRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        moviesRepository.removeAll();

        Movie[] expected = new Movie[0];
        Movie[] actual = moviesRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
