package ztw.books.spring_rest_api.Book;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class BookConfig {
    private final IBookRepository bookRepository;

    @Bean
    public CommandLineRunner addBooks(){
        return args ->{
            Book book1= Book.builder().title("Potop").author("Henryk Sienkiewicz").pages(936).build();
            Book book2= Book.builder().title("Wesele").author("Stanisław Reymon").pages(150).build();
            Book book3= Book.builder().title("Dziady").author("Adam Mickiewicz").pages(292).build();

            bookRepository.saveAll(List.of(book1,book2, book3));
        };
    }
}
