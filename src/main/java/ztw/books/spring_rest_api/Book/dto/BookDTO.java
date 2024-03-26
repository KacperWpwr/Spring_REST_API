package ztw.books.spring_rest_api.Book.dto;

import ztw.books.spring_rest_api.Book.enitity.Author;

public record BookDTO(long id, String title, Author author, int pages) {
}
