package com.jb.authour.service;

import com.jb.authour.beans.Author;
import com.jb.authour.beans.Book;
import com.jb.authour.exception.ErrMsg;
import com.jb.authour.exception.LibraryCustomException;
import com.jb.authour.repos.AuthorRepository;
import com.jb.authour.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addAuthor(Author author) throws LibraryCustomException {
        int id = author.getId();
        if (authorRepository.existsById(id)) {
            throw new LibraryCustomException(ErrMsg.ID_ALREADY_EXIST);
        }
        author.getBooks().forEach(b->b.setAuthor(author));
        authorRepository.save(author);
    }

    @Override
    public void updateAuthor(int id, Author author) throws LibraryCustomException {
        if (!authorRepository.existsById(id)){
            throw new LibraryCustomException(ErrMsg.ID_NOT_FOUND);
        }
        author.setId(id);
        author.getBooks().forEach(b->b.setAuthor(author));
        authorRepository.saveAndFlush(author);
    }

    @Override
    public void deleteAuthor(int id) throws LibraryCustomException {
        if (!authorRepository.existsById(id)) {
            throw new LibraryCustomException(ErrMsg.ID_NOT_FOUND);
        }
        authorRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getSingletAuthor(int id) throws LibraryCustomException {
        return authorRepository.findById(id)
                .orElseThrow(() -> new LibraryCustomException(ErrMsg.ID_NOT_FOUND));
    }

    @Override
    public List<Book> getAllBooksBetweenYears(int start, int end) {
        return this.bookRepository.findByYearBetween(start, end);
    }

    @Override
    public double avgYearsBooks() {
        return bookRepository.avgYearsAllBooks();
    }

    @Override
    public double avgYearsBooksBySpecificAuthor(int id) {
        return bookRepository.avgYearsAllBooksByAuthor(id);
    }
}
