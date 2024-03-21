package ztw.books.spring_rest_api.Book;

import ztw.books.spring_rest_api.Book.dto.BookDTO;

import java.util.Collection;

public interface IBookService {
    Collection<Book> getBooks();
    BookDTO getBook(Long id);
}
