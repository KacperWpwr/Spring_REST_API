package ztw.books.spring_rest_api.Author.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import ztw.books.spring_rest_api.Author.entity.Author;

import java.util.List;

public record CreateAuthorRequest(@NotBlank String firstName,@NotBlank String lastName) {
}
