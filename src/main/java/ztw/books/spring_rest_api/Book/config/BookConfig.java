package ztw.books.spring_rest_api.Book.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Author.repository.IAuthorRepository;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Book.repository.IBookRepository;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class BookConfig {
    private final IBookRepository bookRepository;
    private final IAuthorRepository authorRepository;

    @Bean
    public CommandLineRunner addBooks(){
        return args ->{
            Author author1= Author.builder().firstName("Henryk").lastName("Sienkiewicz").build();
            Author author2= Author.builder().firstName("Stanisław").lastName("Reymont").build();
            Author author3= Author.builder().firstName("Adam").lastName("Mickiewicz").build();
            authorRepository.saveAll(List.of(author1,author2, author3));
            Book book1= Book.builder().title("Potop").author(author1).pages(936).build();
            Book book2= Book.builder().title("Wesele").author(author2).pages(150).build();
            Book book3= Book.builder().title("Dziady").author(author3).pages(292).build();
            bookRepository.saveAll(List.of(book1,book2, book3));
//            Book book1= Book.builder().title("Potop").author("Henryk Sienkiewicz").pages(936).build();
//            Book book2= Book.builder().title("Wesele").author("Stanisław Reymon").pages(150).build();
//            Book book3= Book.builder().title("Dziady").author("Adam Mickiewicz").pages(292).build();

//            bookRepository.saveAll(List.of(book1,book2, book3));
        };
    }
}
