package com.movie.movie.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;


    // Adding movie entries

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    MovieData create(@Valid @RequestBody MovieData data) {
        return movieService.create(data);
    }

    // Edit endpoint
    @PutMapping("/{id}")
    MovieData update(@PathVariable("id") String id, @Valid @RequestBody MovieData data) {
        return movieService.update(id, data);
    }

    @GetMapping
    List<MovieData> findAll() {
        return movieService.findAll();
    }

    @GetMapping(params = "watched")
    List<MovieData> findAll(@RequestParam("watched") boolean watched) {
        return movieService.findWatched(watched);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") String id) {
        movieService.delete(id);
    }
}
