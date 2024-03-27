package ztw.books.spring_rest_api.Author.request;

import jakarta.validation.constraints.Min;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Book.enitity.Book;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateAuthorRequest(String firstName, String lastName, List<Long> bookIds) {
    /*public List<Long> getBookIds() {
        return bookIds.stream().distinct().collect(Collectors.toList());
    }*/
}
