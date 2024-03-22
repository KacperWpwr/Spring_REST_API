package ztw.books.spring_rest_api.Book.request;

import jakarta.validation.constraints.Min;

public record UpdateBookRequest(String title, String author, @Min(0) int pages) {
}
