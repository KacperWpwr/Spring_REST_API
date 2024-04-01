package ztw.books.spring_rest_api.Book.mapper;

import org.springframework.stereotype.Component;
import ztw.books.spring_rest_api.Author.dto.AuthorDTO;
import ztw.books.spring_rest_api.Book.dto.BookDTO;
import ztw.books.spring_rest_api.Book.enitity.Book;

@Component
public class BookMapper {

    public BookDTO mapBookDTO(Book book){
        return new BookDTO(book.getId(), book.getTitle(), new AuthorDTO(book.getAuthor()), book.getPages());
    }
}
