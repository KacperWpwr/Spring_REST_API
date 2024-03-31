package ztw.books.spring_rest_api.Author.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ztw.books.spring_rest_api.Author.dto.AuthorDTO;
import ztw.books.spring_rest_api.Author.entity.Author;
import ztw.books.spring_rest_api.Author.repository.IAuthorRepository;
import ztw.books.spring_rest_api.Author.request.CreateAuthorRequest;
import ztw.books.spring_rest_api.Author.request.UpdateAuthorRequest;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {
    private final IAuthorRepository authorRepository;

    @Override
    public Collection<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorDTO getAuthor(Long id){
        Author author = authorRepository.findById(id).orElse(null);

        if(author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return new AuthorDTO(author);
    }

    @Override
    public AuthorDTO createAuthor(CreateAuthorRequest request) {
        Author author = Author.builder().firstName(request.firstName()).lastName(request.lastName()).build();

        author = authorRepository.save(author);

        return new AuthorDTO(author);
    }

    @Override
    public AuthorDTO updateAuthor(UpdateAuthorRequest request, Long id) {
        Author author = authorRepository.findById(id).orElse(null);

        if(author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        author.setFirstName(request.firstName());
        author.setLastName(request.lastName());

        author = authorRepository.save(author);

        return new AuthorDTO(author);
    }

    @Override
    public Optional<Author> findAuthor(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Collection<AuthorDTO> getAuthorsPaginated(int page, int perPage) {
        return authorRepository.findAll(PageRequest.of(page,perPage)).stream().map(AuthorDTO::new).toList();
    }

    @Override
    public int getTotalPages(int perPage) {
        return authorRepository.findAll(Pageable.ofSize(perPage)).getTotalPages();
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if( !author.getBookIds().isEmpty()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        authorRepository.deleteById(id);
    }
}
