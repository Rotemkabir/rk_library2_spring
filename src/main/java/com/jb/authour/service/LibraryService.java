package com.jb.authour.service;

import com.jb.authour.beans.Author;
import com.jb.authour.beans.Book;
import com.jb.authour.exception.LibraryCustomException;

import java.util.List;

public interface LibraryService {

    void addAuthor(Author author) throws LibraryCustomException;

    void updateAuthor(int id, Author author) throws LibraryCustomException;

    void deleteAuthor(int id) throws LibraryCustomException;

    List<Book> getAllBooks();

    List<Author> getAllAuthors();

    Author getSingletAuthor(int id) throws LibraryCustomException;

    double avgYearsBooks();

    double avgYearsBooksBySpecificAuthor(int id);

    List<Book> getAllBooksBetweenYears(int start, int end);
}
