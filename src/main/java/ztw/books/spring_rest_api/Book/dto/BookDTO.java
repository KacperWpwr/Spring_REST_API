package ztw.books.spring_rest_api.Book.dto;

import ztw.books.spring_rest_api.Author.dto.AuthorDTO;
import ztw.books.spring_rest_api.Author.entity.Author;

public record BookDTO(long id, String title, AuthorDTO author, int pages) {
}
