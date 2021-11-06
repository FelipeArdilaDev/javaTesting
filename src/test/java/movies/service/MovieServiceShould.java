package movies.service;

import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import static movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceShould {

    @InjectMocks
    MovieService movieService;

    @Mock
    MovieRepository movieRepository;

    @Before
    public void setUp() {
        movieService = new MovieService(movieRepository);
        when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "There's Something About Mary", 119, COMEDY),
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Scream", 111, HORROR),
                new Movie(6, "Home Alone", 103, COMEDY),
                new Movie(7, "Matrix", 136, ACTION),
                new Movie(8, "Dark Knight Rises", 152, ACTION),
                new Movie(9, "The Matrix Reloaded", 136, ACTION),
                new Movie(10, "The Matrix Revolutions", 136, ACTION)
        ));
    }

    @Test
    public void returnMoviesByGenre() {
//    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        assertThat(getMoviesIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void returnMoviesByLength() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMoviesIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void returnMovieByName(){
        Collection<Movie> movies = movieService.findMoviesByName("matrix");
        assertThat(getMoviesIds(movies), is(Arrays.asList(7, 9, 10)));
    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }


}