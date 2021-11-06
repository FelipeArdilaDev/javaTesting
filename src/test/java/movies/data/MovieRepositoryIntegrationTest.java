package movies.data;

import movies.model.Movie;
import movies.service.MovieService;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static movies.model.Genre.ACTION;
import static movies.model.Genre.THRILLER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


    @RunWith(MockitoJUnitRunner.class)
    public class MovieRepositoryIntegrationTest {

        private MovieService movieService;

        @InjectMocks
        MovieRepositoryjdbc movieRepository;

        @Mock
        JdbcTemplate jdbcTemplate;
        private DataSource dataSource;

        @Before
        public void setUp() throws SQLException {
            // Database in-memory.
            dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
            jdbcTemplate = new JdbcTemplate(dataSource);
            movieRepository = new MovieRepositoryjdbc(jdbcTemplate);

            // Insert test data into the in-memory database.
            ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        }

        @Test
        public void loadAllMovies() {
            Collection<Movie> movies = movieRepository.findAll();

            assertThat(movies, is(Arrays.asList(
                    new Movie(1, "Dark Knight", 152, ACTION),
                    new Movie(2, "Memento", 113, THRILLER),
                    new Movie(3, "Matrix", 136, ACTION)
            )));
        }


    @Test
    public void loadMovieById() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, CoreMatchers.is(new Movie(2, "Memento", 113, THRILLER)));
    }

        @After
    public void tearDown() throws Exception {
        // Remove H2 files --
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); //"sutddown" is also enough for mem db
    }
}