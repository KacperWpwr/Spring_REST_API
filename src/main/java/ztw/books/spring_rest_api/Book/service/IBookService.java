package ztw.books.spring_rest_api.Book.service;

import ztw.books.spring_rest_api.Book.dto.BookDTO;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Book.request.CreateBookRequest;
import ztw.books.spring_rest_api.Book.request.UpdateBookRequest;

import java.util.Collection;
import java.util.Optional;

public interface IBookService {
    Collection<BookDTO> getBooks();
    BookDTO getBook(Long id);
    BookDTO createBook(CreateBookRequest request);
    BookDTO updateBook(UpdateBookRequest request, Long id);

    void deleteBook(Long id);
    Optional<Book> findBook(long id);
}
