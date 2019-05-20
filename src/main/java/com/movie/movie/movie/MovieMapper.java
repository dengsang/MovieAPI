package com.movie.movie.movie;

import org.springframework.stereotype.Component;


@Component
public class MovieMapper {

    MovieData map(Movie movie) {
        MovieData data = new MovieData ();
        data.setId(movie.getId());
        data.setTitle(movie.getTitle());
        data.setDescription(movie.getDescription());
        data.setRatings(movie.getRatings ());
        data.setRecommendation (movie.getRecommendation());
        data.setWatched(movie.isWatched());
        return data;
    }

    Movie map(MovieData data) {
        Movie movie;
        if (data.getId() != null) {
            movie = new Movie(data.getId());
        } else {
            movie = new Movie();
        }
        movie.setTitle(data.getTitle());
        movie.setDescription(data.getDescription());
        movie.setWatched(data.isWatched());
        return movie;
    }
}
