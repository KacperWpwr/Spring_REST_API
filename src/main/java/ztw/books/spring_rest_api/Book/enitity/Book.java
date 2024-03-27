package ztw.books.spring_rest_api.Book.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Rental.entity.Rental;

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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(mappedBy = "book")
    private Rental rental;

    @JsonIgnore // to prevent author object in Book
    public Author getAuthor() {
        return author;
    }

    public long getAuthorId() {
        return author != null ? author.getId() : 0; // return author id instead
    }
}
