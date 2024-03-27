package ztw.books.spring_rest_api.Book.dto;

import ztw.books.spring_rest_api.Author.entity.Author;

public record BookDTO(long id, String title, long authorId, int pages) {
}
