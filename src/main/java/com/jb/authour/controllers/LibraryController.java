package com.jb.authour.controllers;

import com.jb.authour.beans.Author;
import com.jb.authour.beans.Book;
import com.jb.authour.exception.LibraryCustomException;
import com.jb.authour.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("authors")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor(@RequestBody Author author) throws LibraryCustomException {
        libraryService.addAuthor(author);
    }
    @PutMapping("authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@PathVariable int id,@RequestBody Author author) throws LibraryCustomException {
        libraryService.updateAuthor(id, author);
    }

    @DeleteMapping("authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) throws LibraryCustomException {
        libraryService.deleteAuthor(id);
    }

    @GetMapping("books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("authors")
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("authors/{id}")
    public Author getSingleAuthor(@PathVariable int id) throws LibraryCustomException {
       return libraryService.getSingletAuthor(id);
    }

    //http://localhost:8080/api/library/books/year/between?start=2015&end=2022
    @GetMapping("books/year/between")
    public List<Book>booksBetweenYears(@RequestParam int start , @RequestParam int end){
        return libraryService.getAllBooksBetweenYears(start, end);
    }
    @GetMapping("books/year/avg")
    public double getAvgYears() {
        return libraryService.avgYearsBooks();
    }

    @GetMapping("authors/{id}/books/year/avg")
    public double getAvgYearsById(@PathVariable int id) {
        return libraryService.avgYearsBooksBySpecificAuthor(id);
    }

}
