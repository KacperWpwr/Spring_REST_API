package ztw.books.spring_rest_api.Author.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ztw.books.spring_rest_api.Author.dto.AuthorDTO;
import ztw.books.spring_rest_api.Author.request.CreateAuthorRequest;
import ztw.books.spring_rest_api.Author.request.UpdateAuthorRequest;
import ztw.books.spring_rest_api.Author.service.IAuthorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final IAuthorService authorService;

    @GetMapping
    public ResponseEntity<Object> getAuthors() {
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id){
        return new ResponseEntity<>(authorService.getAuthor(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody CreateAuthorRequest request){
        return new ResponseEntity<>(authorService.createAuthor(request),HttpStatus.CREATED);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody UpdateAuthorRequest request, @PathVariable Long id){
        return new ResponseEntity<>(authorService.updateAuthor(request,id),HttpStatus.CREATED);
    }*/

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
