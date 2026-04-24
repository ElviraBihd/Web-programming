package com.example.demo2_new.Repository;

import com.example.demo2_new.Model.Movies;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    private final JdbcTemplate db;

    public MovieRepository(JdbcTemplate db) {
        this.db = db;
    }

    protected RowMapper<Movies> moviesRowMapper = (rs, i) -> new
            Movies(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getInt("age_limit"),
            rs.getString("type"),
            rs.getString("director")

            );

    public List<Movies> getAllMovies() {
        db.query("SELECT * FROM movies", moviesRowMapper);
    }

    public void addMovie(Movies movies) {
        String sql = "INSERT INTO movies (name, age_limit, type, director) VALUES (?, ?, ?, ?, ?)";
        db.update(sql, movies.getName(), movies.getAge_limit(), movies.getType(), movies.getDirector());
    }

    public void updateMovie(Movies movies) {
        String sql = "UPDATE movies SET name=?, age_limit=?, type=?, director=? WHERE id=?";
        db.update(sql, movies.getName(), movies.getAge_limit(), movies.getType(), movies.getDirector(), movies.getId(), movies.getId());
    }

    public void deleteMovie(Long id) {
        db.update("DELETE FROM movies WHERE id=?", id);
    }
}
