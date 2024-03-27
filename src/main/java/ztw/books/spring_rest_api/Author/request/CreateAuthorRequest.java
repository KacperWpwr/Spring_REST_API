package ztw.books.spring_rest_api.Author.request;

import jakarta.validation.constraints.Min;
import ztw.books.spring_rest_api.Author.entity.Author;

import java.util.List;

public record CreateAuthorRequest(String firstName, String lastName, List<Long> bookIds) {
}
