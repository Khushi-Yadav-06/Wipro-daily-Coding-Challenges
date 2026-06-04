package com.wipro.reactiveHandlerRouter.practice;

import reactor.core.publisher.Mono;

public class ReactiveErrorExample {

    public static void main(String[] args) {

        getData()

                .subscribe(

                        data -> System.out.println("Data: " + data),

                        error -> System.err.println("Error: " + error.getMessage())
                );
    }

    public static Mono<String> getData() {

        double number = Math.random();

        if (number < 0.5) {

            return Mono.error(
                    new RuntimeException("Error occurred! " + number)
            );

        } else {

            return Mono.just("Success! " + number);
        }
    }
}
