package com.wipro.reactiveHandlerRouter.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.wipro.reactiveHandlerRouter.model.Book;

public interface BookRepository  extends ReactiveMongoRepository<Book, Long> {
}


