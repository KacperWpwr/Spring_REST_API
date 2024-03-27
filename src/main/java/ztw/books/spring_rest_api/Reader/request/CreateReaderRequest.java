package ztw.books.spring_rest_api.Reader.request;

import jakarta.validation.constraints.NotBlank;

public record CreateReaderRequest(@NotBlank String name, @NotBlank String lastName) {
}
