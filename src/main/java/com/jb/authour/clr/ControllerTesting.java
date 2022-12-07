package com.jb.authour.clr;

import com.jb.authour.beans.Author;
import com.jb.authour.beans.Book;
import com.jb.authour.exception.ErrMsg;
import com.jb.authour.exception.LibraryCustomException;
import com.jb.authour.repos.AuthorRepository;
import com.jb.authour.repos.BookRepository;
import com.jb.authour.utils.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@Order(3)
public class ControllerTesting implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Value("${URL}")
    private String URL;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Colors.CYAN_BACKGROUND_BRIGHT + "" + Colors.BLUE + "-------------REST TEMPLATE-------------" + Colors.RESET);
        System.out.println(Colors.BLUE + "Add author" + Colors.RESET);
        addAuthorTest();
        System.out.println(Colors.BLUE + "Update author" + Colors.RESET);
        updateAuthorTest();
        System.out.println(Colors.BLUE + "Delete author" + Colors.RESET);
        deleteAuthorTest();
        System.out.println(Colors.BLUE + "Get all books" + Colors.RESET);
        getAllBooksTest();
        System.out.println(Colors.BLUE + "Get all authors" + Colors.RESET);
        getAllAuthorsTest();
        System.out.println(Colors.BLUE + "Get single author" + Colors.RESET);
        getSingleAuthorTest();
        System.out.println(Colors.BLUE + "Avg Years Books" + Colors.RESET);
        avgYearsBooksTest();
        System.out.println(Colors.BLUE + "Avg Years Books By Specific Author" + Colors.RESET);
        avgYearsBooksBySpecificAuthorTest();
        System.out.println(Colors.BLUE + "Get All Books Between Years" + Colors.RESET);
        getAllBooksBetweenYearsTest();
    }

    public void addAuthorTest() {
        Book b1 = Book.builder()
                .name("To love what is22")
                .year(1887)
                .build();
        Book b2 = Book.builder()
                .name("I need your love22")
                .year(1990)
                .build();
        Author a1 = Author.builder()
                .name("ester")
                .books(List.of(b1, b2))
                .build();
        b1.setAuthor(a1);
        b2.setAuthor(a1);
        ResponseEntity<String> res1 = restTemplate.postForEntity(URL + "/authors", a1, String.class);
        System.out.println(res1.getStatusCode());
    }

    public void updateAuthorTest() {
        try {
            System.out.println("before update");
            authorRepository.findAll().forEach(System.out::println);
            Author a1 = authorRepository.findById(1).orElseThrow(() -> new LibraryCustomException(ErrMsg.ID_NOT_FOUND));
            a1.setName("nnn");
            restTemplate.put(URL + "/authors/1", a1);
            System.out.println("after update");
            authorRepository.findAll().forEach(System.out::println);
        } catch (LibraryCustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAuthorTest() {
        System.out.println("before delete");
        authorRepository.findAll().forEach(System.out::println);
        restTemplate.delete(URL + "/authors/1");
        System.out.println("after delete");
        authorRepository.findAll().forEach(System.out::println);
    }

    public void getAllBooksTest() {
        Book[] books = restTemplate.getForObject(URL + "/books", Book[].class);
        Arrays.asList(books).forEach(System.out::println);
    }

    public void getAllAuthorsTest() {
        Author[] authors = restTemplate.getForObject(URL + "/authors", Author[].class);
        Arrays.asList(authors).forEach(System.out::println);
    }

    public void getSingleAuthorTest() {
        Author author = restTemplate.getForObject(URL + "/authors/3", Author.class);
        System.out.println(author);
    }

    public void avgYearsBooksTest() {
        Double avg = restTemplate.getForObject(URL + "/books/year/avg", Double.class);
        System.out.println(avg);

    }

    public void avgYearsBooksBySpecificAuthorTest() {
        Double avg = restTemplate.getForObject(URL + "/authors/4/books/year/avg", Double.class);
        System.out.println(avg);
    }

    public void getAllBooksBetweenYearsTest() {
        Book[] books = restTemplate.getForObject(URL + "/books/year/between?start=1860&end=1988", Book[].class);
        Arrays.asList(books).forEach(System.out::println);
    }

}
