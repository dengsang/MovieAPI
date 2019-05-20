package com.movie.movie.movie;

import com.movie.movie.user.User;
import lombok.RequiredArgsConstructor;

import com.movie.movie.system.exception.NotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class MovieService {


    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Transactional
    public MovieData create(MovieData movieData) {
        Movie movie = movieMapper.map( movieData );
        User user = new User();
        user.setLogin( SecurityContextHolder.getContext().getAuthentication().getName());
        movie.setUser(user);
        movie = movieRepository.save(movie);
        return movieMapper.map(movie);
    }

    public List<MovieData> findAll() {
        return movieRepository.findAll().stream()
                .map(movieMapper::map)
                .collect(toList());
    }

    public List<MovieData> findWatched(boolean watched) {
        return movieRepository.findByWatched(watched).stream()
                .map(movieMapper::map)
                .collect(toList());
    }

    @Transactional
    public MovieData update(String id, MovieData data) {
        Movie movie = movieRepository.findById(id).orElseThrow (NotFoundException::new );
        //() -> new NotFoundException ()
        //NotFoundException::new
        movie.setTitle(data.getTitle());
        movie.setDescription(data.getDescription());
        movie.setRatings (data.getRatings ());
        movie.setRecommendation ( data.getRecommendation ());
        movie.setWatched(data.isWatched());
        return movieMapper.map(movie);
    }

    @Transactional
    public void delete(String id, MovieData data) {
        movieRepository.delete(data);
    }

    public void delete(String id) {
    }
}
