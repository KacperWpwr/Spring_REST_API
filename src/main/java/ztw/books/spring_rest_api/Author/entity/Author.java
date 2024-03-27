package ztw.books.spring_rest_api.Author.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import ztw.books.spring_rest_api.Book.enitity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Book> books = new ArrayList<>();

    @JsonIgnore // to prevent books list in Author
    public List<Book> getBooks() {
        return books;
    }

    public List<Long> getBookIds() {
        return books.stream().map(Book::getId).collect(Collectors.toList()); // return list of books' ids instead
    }
}
