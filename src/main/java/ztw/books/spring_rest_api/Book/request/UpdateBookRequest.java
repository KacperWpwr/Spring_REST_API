package ztw.books.spring_rest_api.Book.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import ztw.books.spring_rest_api.Author.entity.Author;

public record UpdateBookRequest(@NotBlank String title, @NotBlank long author_id,@NotBlank @Min(0) int pages) {
}
