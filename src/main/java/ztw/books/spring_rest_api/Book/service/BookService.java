package ztw.books.spring_rest_api.Book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Author.service.IAuthorService;
import ztw.books.spring_rest_api.Book.repository.IBookRepository;
import ztw.books.spring_rest_api.Book.dto.BookDTO;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Book.request.CreateBookRequest;
import ztw.books.spring_rest_api.Book.request.UpdateBookRequest;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService{
    private final IBookRepository bookRepository;
    private final IAuthorService authorService;



    @Override
    public Collection<BookDTO> getBooks() {
        return bookRepository.findAll().stream()
                .map(book ->new BookDTO(book.getId(),book.getTitle(),  book.getAuthorId(),book.getPages()))
                .toList();
    }

    @Override
    public BookDTO getBook(Long id){
        Book book = bookRepository.findById(id).orElse(null);

        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthorId(), book.getPages());
    }

    @Override
    public BookDTO createBook(CreateBookRequest request) {
        Author author = authorService.findAuthor(request.author_id())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Book book = Book.builder().title(request.title()).author(author).pages(request.pages()).build();

        book = bookRepository.save(book);

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthorId(), book.getPages());
    }

    @Override
    public BookDTO updateBook(UpdateBookRequest request, Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Author author = authorService.findAuthor(request.author_id())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        book.setAuthor(author);
        book.setTitle(request.title());
        book.setPages(request.pages());

        book = bookRepository.save(book);

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthorId(), book.getPages());
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findBook(long id){
        return bookRepository.findById(id);
    }


}
