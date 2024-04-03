package ztw.books.spring_rest_api.Rental.requests;

import jakarta.validation.constraints.NotBlank;

public record UpdateRentalRequest(@NotBlank long book_id, @NotBlank long reader_id) {
}
