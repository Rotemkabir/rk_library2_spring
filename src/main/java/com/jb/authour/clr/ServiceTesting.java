package com.jb.authour.clr;

import com.jb.authour.beans.Author;
import com.jb.authour.beans.Book;
import com.jb.authour.service.LibraryService;
import com.jb.authour.utils.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class ServiceTesting implements CommandLineRunner {

    @Autowired
    private LibraryService libraryService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Colors.CYAN_BACKGROUND_BRIGHT + "" + Colors.BLUE + "-------------SERVICE TESTING-------------" + Colors.RESET);

        System.out.println("Get all books");
        libraryService.getAllBooks().forEach(System.out::println);

        System.out.println(Colors.BLUE +"Add new author"+ Colors.RESET);
        Book b1 = Book.builder()
                .name("The easiest way to quit smoking")
                .year(1988)
                .build();
        Author a1 = Author.builder()
                .name("ellen ka`ar")
                .books(List.of(b1))
                .build();
        b1.setAuthor(a1);
        libraryService.addAuthor(a1);
        System.out.println(a1);

        System.out.println(Colors.BLUE +"Update author"+ Colors.RESET);
        Author toUpdate = libraryService.getSingletAuthor(2);
        toUpdate.setName("bbbb");
        libraryService.updateAuthor(2, toUpdate);
        System.out.println(libraryService.getSingletAuthor(2));

        System.out.println(Colors.BLUE +"Get all authors"+ Colors.RESET);
        libraryService.getAllAuthors().forEach(System.out::println);

        System.out.println(Colors.BLUE +"Get all books"+ Colors.RESET);
        libraryService.getAllBooks().forEach(System.out::println);

        System.out.println(Colors.BLUE +"Delete author #2"+ Colors.RESET);
        libraryService.deleteAuthor(2);
        libraryService.getAllAuthors().forEach(System.out::println);

        System.out.println(Colors.BLUE +"Get single author #1"+ Colors.RESET);
        System.out.println(libraryService.getSingletAuthor(1));

        System.out.println(Colors.BLUE +"Get all books between years 1870-1989"+ Colors.RESET);
        libraryService.getAllBooksBetweenYears(1870,1989).forEach(System.out::println);

        System.out.println(Colors.BLUE +"Avg years all books"+ Colors.RESET);
        System.out.println(libraryService.avgYearsBooks());

        System.out.println(Colors.BLUE +"Avg years books by author #1"+ Colors.RESET);
        System.out.println(libraryService.avgYearsBooksBySpecificAuthor(1));
    }
}
