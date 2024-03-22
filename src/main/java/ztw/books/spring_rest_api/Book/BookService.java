package ztw.books.spring_rest_api.Book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ztw.books.spring_rest_api.Book.dto.BookDTO;
import ztw.books.spring_rest_api.Book.request.CreateBookRequest;
import ztw.books.spring_rest_api.Book.request.UpdateBookRequest;

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPages());
    }

    @Override
    public BookDTO createBook(CreateBookRequest request) {
        Book book = Book.builder().title(request.title()).author(request.author()).pages(request.pages()).build();

        book = bookRepository.save(book);

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPages());
    }

    @Override
    public BookDTO updateBook(UpdateBookRequest request, Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        book.setAuthor(request.author());
        book.setTitle(request.title());
        book.setPages(request.pages());

        book = bookRepository.save(book);

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPages());
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteById(id);
    }


}
