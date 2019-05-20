package com.movie.movie.movie;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


@Data
public class MovieDto {
    private String id;

    @NotNull
    @Length(min = 1, max = 100)
    private String title;

    @NotNull
    @Length(min = 1, max = 500)
    private String description;

    private String recommendation;

    private  int ratings;

    private boolean watched;



}
