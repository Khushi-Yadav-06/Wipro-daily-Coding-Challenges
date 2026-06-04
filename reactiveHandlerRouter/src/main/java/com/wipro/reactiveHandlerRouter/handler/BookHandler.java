
package com.wipro.reactiveHandlerRouter.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wipro.reactiveHandlerRouter.model.Book;
import com.wipro.reactiveHandlerRouter.service.BookService;

import reactor.core.publisher.Mono;

@Component
public class BookHandler {

    @Autowired
    BookService service;

    public Mono<ServerResponse> getBooksList(ServerRequest req) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getBook(), Book.class);
    }

    public Mono<ServerResponse> getBookData(ServerRequest req) {

        Long id = Long.parseLong(req.pathVariable("id"));

        return service.getSingleBook(id)
                .flatMap(book ->

                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(book)
                );
    }

    public Mono<ServerResponse> saveBook(ServerRequest request) {

        Mono<Book> bookMono = request.bodyToMono(Book.class);

        return service.addBook(bookMono)
                .flatMap(savedBook ->

                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(savedBook)
                );
    }
}

