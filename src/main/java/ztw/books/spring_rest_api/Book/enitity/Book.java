package ztw.books.spring_rest_api.Book.enitity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter@Setter
public class Book {
    @SequenceGenerator(
            sequenceName = "book_sequence",
            name = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "book_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private long id;
    private String title;
//    private String author;
    private int pages;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
