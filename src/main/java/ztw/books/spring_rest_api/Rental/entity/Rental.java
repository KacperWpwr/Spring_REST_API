package ztw.books.spring_rest_api.Rental.entity;

import jakarta.persistence.*;
import lombok.*;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Reader.entity.Reader;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Rental {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @OneToOne
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader")
    private Reader reader;
}
