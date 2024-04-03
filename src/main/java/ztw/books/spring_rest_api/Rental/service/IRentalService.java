package ztw.books.spring_rest_api.Rental.service;

import ztw.books.spring_rest_api.Author.request.UpdateAuthorRequest;
import ztw.books.spring_rest_api.Rental.dto.RentalDTO;
import ztw.books.spring_rest_api.Rental.requests.RentBookRequest;
import ztw.books.spring_rest_api.Rental.requests.UpdateRentalRequest;

import java.util.List;

public interface IRentalService {
    RentalDTO rentBook(RentBookRequest request);
    RentalDTO getRental(long id);
    RentalDTO getRentalbyBook(long bookId);
    List<RentalDTO> getRentalsbyReader(long readerId);
    List<RentalDTO> getAllRentals();
    void returnBook(long bookId);
    RentalDTO updateRental(UpdateRentalRequest request, Long id);

    List<RentalDTO> getRentalsPaginated(int page, int perPage);
    int getTotalPages(int perPage);

}
