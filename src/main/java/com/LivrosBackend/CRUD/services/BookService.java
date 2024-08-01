package com.LivrosBackend.CRUD.services;

import com.LivrosBackend.CRUD.dtos.BookRecordDto;
import com.LivrosBackend.CRUD.models.BookModel;
import com.LivrosBackend.CRUD.models.ReviewModel;
import com.LivrosBackend.CRUD.repositories.AuthorRepository;
import com.LivrosBackend.CRUD.repositories.BookRepository;
import com.LivrosBackend.CRUD.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }


}