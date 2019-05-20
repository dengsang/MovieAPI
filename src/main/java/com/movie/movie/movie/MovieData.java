package com.movie.movie.movie;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Data
@Component
public class MovieData extends Movie {
    private String id;

    @NotNull
    @Length(min = 1, max = 100)
    private String title;

    @NotNull
    @Length(min = 1, max = 500)
    private String description;

    @NotNull
    @Length(min = 1, max = 50)
    private String recommendation;

    @NotNull
    private  String ratings;

    private boolean watched;



}
