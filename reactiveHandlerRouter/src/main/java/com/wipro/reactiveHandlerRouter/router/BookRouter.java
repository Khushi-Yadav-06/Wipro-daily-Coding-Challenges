package com.wipro.reactiveHandlerRouter.router;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.reactive.function.server.RouterFunction;

import com.wipro.reactiveHandlerRouter.handler.BookHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
	import static org.springframework.web.reactive.function.server.RouterFunctions.route;

	@Configuration
	public class BookRouter {

	    @Bean
	    public RouterFunction<?> routes(BookHandler handler) {

	        return route(GET("/books"),
	                handler::getBooksList)

	                .andRoute(GET("/books/{id}"),
	                        handler::getBookData)

	                .andRoute(POST("/add"),
	                        handler::saveBook);
	    }
	}


