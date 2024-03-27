package ztw.books.spring_rest_api.Rental.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ztw.books.spring_rest_api.Rental.dto.RentalDTO;
import ztw.books.spring_rest_api.Rental.requests.RentBookRequest;
import ztw.books.spring_rest_api.Rental.service.IRentalService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final IRentalService rentalService;
    @GetMapping
    public ResponseEntity<Object> getAllRentals(){
        return new ResponseEntity<>(rentalService.getAllRentals(), HttpStatus.OK);
    }
    @GetMapping("/reader/{id}")
    public ResponseEntity<Object> getAllRentalsByReader(@PathVariable long id){
        return new ResponseEntity<>(rentalService.getRentalsbyReader(id), HttpStatus.OK);
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<RentalDTO> getRentalByBook(@PathVariable long id){
        return new ResponseEntity<>(rentalService.getRentalbyBook(id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRentalById(@PathVariable long id){
        return new ResponseEntity<>(rentalService.getRental(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalDTO> rentBook(@RequestBody RentBookRequest request){
        return new ResponseEntity<>(rentalService.rentBook(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void returnBook(@PathVariable long id){
        rentalService.returnBook(id);
    }
}