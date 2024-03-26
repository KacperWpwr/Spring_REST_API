package ztw.books.spring_rest_api.Book.request;

import jakarta.validation.constraints.Min;
import ztw.books.spring_rest_api.Book.enitity.Author;

public record CreateBookRequest(String title, Author author, @Min(0) int pages) {
}
