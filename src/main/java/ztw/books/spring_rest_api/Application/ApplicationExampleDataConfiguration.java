package ztw.books.spring_rest_api.Application;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Author.repository.IAuthorRepository;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Book.repository.IBookRepository;
import ztw.books.spring_rest_api.Reader.entity.Reader;
import ztw.books.spring_rest_api.Reader.repository.IReaderRepository;
import ztw.books.spring_rest_api.Rental.entity.Rental;
import ztw.books.spring_rest_api.Rental.repository.IRentalRepository;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationExampleDataConfiguration {
    private final IAuthorRepository authorRepository;
    private final IBookRepository bookRepository;
    private final IRentalRepository rentalRepository;
    private final IReaderRepository readerRepository;

    @Bean
    public CommandLineRunner fillDatabase() {
        return args -> {
            Author author1 = Author.builder().firstName("Henryk").lastName("Sienkiewicz").build();
            Author author2 = Author.builder().firstName("Stanisław").lastName("Reymont").build();
            Author author3 = Author.builder().firstName("Adam").lastName("Mickiewicz").build();
            authorRepository.saveAll(List.of(author1, author2, author3));
            Book book1 = Book.builder().title("Potop").author(author1).pages(936).build();
            Book book2 = Book.builder().title("Wesele").author(author2).pages(150).build();
            Book book3 = Book.builder().title("Dziady").author(author3).pages(292).build();
            bookRepository.saveAll(List.of(book1, book2, book3));
            Reader reader1 = Reader.builder().name("Jan").lastName("Kowalski").build();
            Reader reader2 = Reader.builder().name("Adam").lastName("Nowak").build();
            readerRepository.saveAll(List.of(reader1, reader2));
            Rental rental1 = Rental.builder().reader(reader1).book(book1).build();
            Rental rental2 = Rental.builder().reader(reader2).book(book2).build();
            rentalRepository.saveAll(List.of(rental1, rental2));
        };
    }
}
