package ztw.books.spring_rest_api.Book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Author.service.IAuthorService;
import ztw.books.spring_rest_api.Book.mapper.BookMapper;
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
    private final BookMapper bookMapper;



    @Override
    public Collection<BookDTO> getBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::mapBookDTO)
                .toList();
    }

    @Override
    public BookDTO getBook(Long id){
        Book book = bookRepository.findById(id).orElse(null);

        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }

        return bookMapper.mapBookDTO(book);
    }

    @Override
    public BookDTO createBook(CreateBookRequest request) {
        Author author = authorService.findAuthor(request.author_id())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Book book = Book.builder().title(request.title()).author(author).pages(request.pages()).build();

        book = bookRepository.save(book);

        return bookMapper.mapBookDTO(book);
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

        return bookMapper.mapBookDTO(book);
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

    @Override
    public Collection<BookDTO> getBooksPaginated(int page, int perPage) {
        return bookRepository.findAll(PageRequest.of(page,perPage)).stream()
                .map(bookMapper::mapBookDTO)
                .toList();
    }

    @Override
    public int getTotalPages(int perPage) {
        return bookRepository.findAll(Pageable.ofSize(perPage)).getTotalPages();
    }


}
