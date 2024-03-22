package ztw.books.spring_rest_api.Book;

import ztw.books.spring_rest_api.Book.dto.BookDTO;
import ztw.books.spring_rest_api.Book.request.CreateBookRequest;
import ztw.books.spring_rest_api.Book.request.UpdateBookRequest;

import java.util.Collection;

public interface IBookService {
    Collection<Book> getBooks();
    BookDTO getBook(Long id);
    BookDTO createBook(CreateBookRequest request);
    BookDTO updateBook(UpdateBookRequest request, Long id);

    void deleteBook(Long id);
}
