package ztw.books.spring_rest_api.Author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Book.dto.BookDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Long> bookIds; // list of books' ids

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.bookIds = author.getBookIds();
    }
}
