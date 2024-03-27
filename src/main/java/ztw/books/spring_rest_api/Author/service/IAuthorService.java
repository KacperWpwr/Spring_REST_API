package ztw.books.spring_rest_api.Author.service;

import ztw.books.spring_rest_api.Author.dto.AuthorDTO;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Author.request.CreateAuthorRequest;
import ztw.books.spring_rest_api.Author.request.UpdateAuthorRequest;
import ztw.books.spring_rest_api.Book.dto.BookDTO;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Book.request.CreateBookRequest;
import ztw.books.spring_rest_api.Book.request.UpdateBookRequest;

import java.util.Collection;

public interface IAuthorService {

    Collection<Author> getAuthors();

    AuthorDTO getAuthor(Long id);

    AuthorDTO createAuthor(CreateAuthorRequest request);

    void deleteAuthor(Long id);
}
