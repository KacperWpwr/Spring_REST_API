package ztw.books.spring_rest_api.Author.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Book.enitity.Book;

import java.util.List;
import java.util.stream.Collectors;

public record UpdateAuthorRequest(@NotBlank String firstName,@NotBlank String lastName) {

}
