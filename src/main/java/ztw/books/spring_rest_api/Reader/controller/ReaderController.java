package ztw.books.spring_rest_api.Reader.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ztw.books.spring_rest_api.Reader.dto.ReaderDTO;
import ztw.books.spring_rest_api.Reader.request.CreateReaderRequest;
import ztw.books.spring_rest_api.Reader.service.IReaderService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final IReaderService readerService;

    @GetMapping
    public ResponseEntity<Object> getAllReaders(){
        return new ResponseEntity<>(readerService.getReaders(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderDTO> getReader(@PathVariable long id){
        return new ResponseEntity<>(readerService.getReader(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<ReaderDTO> createReader(@RequestBody CreateReaderRequest request){
        return new ResponseEntity<>(readerService.createReader(request),HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReaderDTO> updateReader(@RequestBody CreateReaderRequest request, @PathVariable long id){
        return new ResponseEntity<>(readerService.updateReader(request,id),HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable long id){
        readerService.deleteReader(id);
    }
}
