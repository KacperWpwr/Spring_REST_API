package ztw.books.spring_rest_api.Rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Book.service.IBookService;
import ztw.books.spring_rest_api.Reader.entity.Reader;
import ztw.books.spring_rest_api.Reader.service.IReaderService;
import ztw.books.spring_rest_api.Rental.dto.RentalDTO;
import ztw.books.spring_rest_api.Rental.entity.Rental;
import ztw.books.spring_rest_api.Rental.repository.IRentalRepository;
import ztw.books.spring_rest_api.Rental.requests.RentBookRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService implements IRentalService{
    private final IRentalRepository rentalRepository;
    private final IBookService bookService;
    private final IReaderService readerService;


    @Override
    public RentalDTO rentBook(RentBookRequest request) {
        if (rentalRepository.getRentalByBook(request.bookId()) != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Book book = bookService.findBook(request.bookId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Reader reader = readerService.findReader(request.readerId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Rental rental = Rental.builder()
                .book(book)
                .reader(reader)
                .build();
        rental = rentalRepository.save(rental);

        return new RentalDTO(rental.getId(), rental.getBook().getId(), rental.getReader().getId());
    }

    @Override
    public RentalDTO getRental(long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new RentalDTO(rental.getId(), rental.getBook().getId(), rental.getReader().getId());

    }

    @Override
    public RentalDTO getRentalbyBook(long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        return new RentalDTO(rental.getId(), rental.getBook().getId(), rental.getReader().getId());
    }

    @Override
    public List<RentalDTO> getRentalsbyReader(long readerId) {
        List<Rental> rentals = rentalRepository.getRentalByReader(readerId);
        return rentals.stream()
                .map(rental -> new RentalDTO(rental.getId(), rental.getBook().getId(), rental.getReader().getId()))
                .toList();
    }

    @Override
    public List<RentalDTO> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream()
                .map(rental -> new RentalDTO(rental.getId(), rental.getBook().getId(), rental.getReader().getId()))
                .toList();
    }

    @Override
    public void returnBook(long bookId) {
        Rental rental = rentalRepository.getRentalByBook(bookId);
        if(rental == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        rentalRepository.delete(rental);
    }
}
