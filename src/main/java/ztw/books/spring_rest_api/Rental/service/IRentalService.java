package ztw.books.spring_rest_api.Rental.service;

import ztw.books.spring_rest_api.Rental.dto.RentalDTO;
import ztw.books.spring_rest_api.Rental.requests.RentBookRequest;

import java.util.List;

public interface IRentalService {
    RentalDTO rentBook(RentBookRequest request);
    RentalDTO getRental(long id);
    RentalDTO getRentalbyBook(long bookId);
    List<RentalDTO> getRentalsbyReader(long readerId);
    List<RentalDTO> getAllRentals();
    void returnBook(long bookId);

}
