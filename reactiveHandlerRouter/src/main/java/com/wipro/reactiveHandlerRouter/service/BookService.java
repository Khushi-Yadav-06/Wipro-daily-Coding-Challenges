package com.wipro.reactiveHandlerRouter.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.reactiveHandlerRouter.model.Book;
import com.wipro.reactiveHandlerRouter.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BookService {
	@Autowired BookRepository repository; 

	public Flux<Book> getBook() {
		return repository.findAll(); 
	}
	public Mono<Book> getSingleBook(long id) { 
		return repository.findById(id) .switchIfEmpty( Mono.error( new RuntimeException("Book not found!")
				) ) .onErrorResume(ex -> { Book errorBook = new Book();
	errorBook.setName(ex.getMessage()); return Mono.just(errorBook); }); 
		}
	
	public Mono<Book> addBook(Mono<Book> obj) { 
		return obj.flatMap(book -> repository.save(book)); 
		}
}
//public Mono<Book> getSingleBook(long id) {
//	return repository.existsById(id) .flatMap(exists -> {
//		if (!exists)
//{ return Mono.error( new RuntimeException("Book is not found!") );
//} 
//		return repository.findById(id); }); }