package ztw.books.spring_rest_api.Book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ztw.books.spring_rest_api.Book.dto.BookDTO;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService{
    private final IBookRepository bookRepository;



    @Override
    public Collection<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookDTO getBook(Long id){
        Book book = bookRepository.findById(id).orElse(null);

        if(book == null){
            return null;
        }

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPages());
    }
}
