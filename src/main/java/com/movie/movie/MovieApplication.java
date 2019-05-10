package com.movie.movie;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run ( MovieApplication.class, args );
	}

	@Bean
	public Docket newsApi() {
		return new Docket ( DocumentationType.SWAGGER_2 )
				.groupName ( "movie" )
				.select ()
				.apis ( RequestHandlerSelectors.any () )
				.paths ( Predicates.not ( PathSelectors.regex ( "/error" ) ) )
				.build ();

	}
}