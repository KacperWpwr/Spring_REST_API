package ztw.books.spring_rest_api.Rental.requests;

import jakarta.validation.constraints.NotBlank;

public record RentBookRequest(@NotBlank long bookId, @NotBlank long readerId) {
}
