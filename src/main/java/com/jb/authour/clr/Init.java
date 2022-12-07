package com.jb.authour.clr;

import com.jb.authour.beans.Author;
import com.jb.authour.beans.Book;
import com.jb.authour.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        Book b1 = Book.builder()
                .name("To love what is")
                .year(1880)
                .build();
        Book b2 = Book.builder()
                .name("I need your love")
                .year(1990)
                .build();

        Book b3 = Book.builder()
                .name("Life is just a period")
                .year(2020)
                .build();

        Book b4 = Book.builder()
                .name("Life is a difficult time")
                .year(2003)
                .build();

        Author a1 = Author.builder()
                .name("byron kate")
                .books(List.of(b1, b2))
                .build();

        Author a2 = Author.builder()
                .name("hanoch daum")
                .books(List.of(b3, b4))
                .build();

        b1.setAuthor(a1);
        b2.setAuthor(a1);
        b3.setAuthor(a2);
        b4.setAuthor(a2);

        authorRepository.saveAll(List.of(a1, a2));
    }
}
