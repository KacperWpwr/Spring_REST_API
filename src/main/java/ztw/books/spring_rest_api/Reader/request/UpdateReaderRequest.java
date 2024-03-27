package ztw.books.spring_rest_api.Reader.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateReaderRequest(@NotBlank String name, @NotBlank String lastName) {
}
