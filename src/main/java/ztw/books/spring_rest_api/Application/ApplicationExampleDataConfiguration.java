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
            List<Author> allAuthors = List.of(
                    Author.builder().firstName("Henryk").lastName("Sienkiewicz").build(),
                    Author.builder().firstName("Stanisław").lastName("Reymont").build(),
                    Author.builder().firstName("Adam").lastName("Mickiewicz").build(),
                    Author.builder().firstName("Emily").lastName("Dickinson").build(),
                    Author.builder().firstName("Leo").lastName("Tolstoy").build(),
                    Author.builder().firstName("Jane").lastName("Austen").build(),
                    Author.builder().firstName("Fyodor").lastName("Dostoevsky").build(),
                    Author.builder().firstName("Mark").lastName("Twain").build(),
                    Author.builder().firstName("Virginia").lastName("Woolf").build(),
                    Author.builder().firstName("Ernest").lastName("Hemingway").build(),
                    Author.builder().firstName("Charles").lastName("Dickens").build(),
                    Author.builder().firstName("Homer").lastName("").build(),
                    Author.builder().firstName("Gabriel").lastName("García Márquez").build(),
                    Author.builder().firstName("J.K.").lastName("Rowling").build(),
                    Author.builder().firstName("Haruki").lastName("Murakami").build(),
                    Author.builder().firstName("Toni").lastName("Morrison").build(),
                    Author.builder().firstName("J.R.R.").lastName("Tolkien").build(),
                    Author.builder().firstName("Stephen").lastName("King").build(),
                    Author.builder().firstName("Agatha").lastName("Christie").build(),
                    Author.builder().firstName("Oscar").lastName("Wilde").build(),
                    Author.builder().firstName("George").lastName("Orwell").build(),
                    Author.builder().firstName("Jorge Luis").lastName("Borges").build(),
                    Author.builder().firstName("John").lastName("Steinbeck").build(),
                    Author.builder().firstName("William").lastName("Faulkner").build(),
                    Author.builder().firstName("Hermann").lastName("Hesse").build(),
                    Author.builder().firstName("Jules").lastName("Verne").build(),
                    Author.builder().firstName("Franz").lastName("Kafka").build(),
                    Author.builder().firstName("Albert").lastName("Camus").build(),
                    Author.builder().firstName("Anton").lastName("Chekhov").build(),
                    Author.builder().firstName("Mary").lastName("Shelley").build()
            );

            authorRepository.saveAll(allAuthors);
            Book book1 = Book.builder().title("Potop").author(allAuthors.get(0)).pages(936).build();
            Book book2 = Book.builder().title("Wesele").author(allAuthors.get(1)).pages(150).build();
            Book book3 = Book.builder().title("Dziady").author(allAuthors.get(2)).pages(292).build();
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
