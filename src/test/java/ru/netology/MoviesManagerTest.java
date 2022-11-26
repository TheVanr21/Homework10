package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {

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

    MoviesManager affiche = new MoviesManager();
    MoviesManager affiche2 = new MoviesManager(5);


    @Test
    public void shouldAddMovie() {
        affiche.add(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = affiche.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovie2() {
        affiche2.add(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = affiche2.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMovies() {
        affiche.add(movie1);
        affiche.add(movie2);
        affiche.add(movie3);
        affiche.add(movie4);
        affiche.add(movie5);
        affiche.add(movie6);
        affiche.add(movie7);
        affiche.add(movie8);
        affiche.add(movie9);
        affiche.add(movie10);
        affiche.add(movie11);
        affiche.add(movie12);

        Movie[] expected = {movie12, movie11, movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3};
        Movie[] actual = affiche.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMovies2() {
        affiche2.add(movie1);
        affiche2.add(movie2);
        affiche2.add(movie3);
        affiche2.add(movie4);
        affiche2.add(movie5);
        affiche2.add(movie6);
        affiche2.add(movie7);
        affiche2.add(movie8);
        affiche2.add(movie9);
        affiche2.add(movie10);
        affiche2.add(movie11);
        affiche2.add(movie12);

        Movie[] expected = {movie12, movie11, movie10, movie9, movie8};
        Movie[] actual = affiche2.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesIfAddedNotEnough() {
        affiche.add(movie1);
        affiche.add(movie2);
        affiche.add(movie3);
        affiche.add(movie4);
        affiche.add(movie5);
        affiche.add(movie6);

        Movie[] expected = {movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = affiche.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesIfAddedNotEnough2() {
        affiche2.add(movie1);
        affiche2.add(movie2);

        Movie[] expected = {movie2, movie1};
        Movie[] actual = affiche2.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSetNegativeLimit() {
        MoviesManager affiche3 = new MoviesManager(-1);

        int expected = 10;
        int actual = affiche3.getLimit();

        Assertions.assertEquals(expected, actual);
    }

}
