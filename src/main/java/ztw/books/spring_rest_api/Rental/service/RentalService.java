package ztw.books.spring_rest_api.Rental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ztw.books.spring_rest_api.Book.enitity.Book;
import ztw.books.spring_rest_api.Book.service.IBookService;
import ztw.books.spring_rest_api.Reader.entity.Reader;
import ztw.books.spring_rest_api.Reader.service.IReaderService;
import ztw.books.spring_rest_api.Rental.dto.RentalDTO;
import ztw.books.spring_rest_api.Rental.entity.Rental;
import ztw.books.spring_rest_api.Rental.mapper.RentalMapper;
import ztw.books.spring_rest_api.Rental.repository.IRentalRepository;
import ztw.books.spring_rest_api.Rental.requests.RentBookRequest;
import ztw.books.spring_rest_api.Rental.requests.UpdateRentalRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService implements IRentalService{
    private final IRentalRepository rentalRepository;
    private final IBookService bookService;
    private final IReaderService readerService;
    private final RentalMapper rentalMapper;


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

        return rentalMapper.getRentalDTO(rental);
    }

    @Override
    public RentalDTO getRental(long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return rentalMapper.getRentalDTO(rental);

    }

    @Override
    public RentalDTO getRentalbyBook(long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        return rentalMapper.getRentalDTO(rental);
    }

    @Override
    public List<RentalDTO> getRentalsbyReader(long readerId) {
        List<Rental> rentals = rentalRepository.getRentalByReader(readerId);
        return rentals.stream()
                .map(rentalMapper::getRentalDTO)
                .toList();
    }

    @Override
    public List<RentalDTO> getAllRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream()
                .map(rentalMapper::getRentalDTO)
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

    @Override
    public RentalDTO updateRental(UpdateRentalRequest request, Long id) {
        Rental rental = rentalRepository.findById(id).orElse(null);

        if(rental == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Book book = bookService.findBook(request.book_id())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        Reader reader = readerService.findReader(request.reader_id())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        rental.setBook(book);
        rental.setReader(reader);

        rental = rentalRepository.save(rental);

        return rentalMapper.getRentalDTO(rental);
    }

    @Override
    public List<RentalDTO> getRentalsPaginated(int page, int perPage) {
        return rentalRepository.findAll(PageRequest.of(page,perPage)).stream()
                .map(rentalMapper::getRentalDTO).toList();
    }

    @Override
    public int getTotalPages(int perPage) {
        return rentalRepository.findAll(Pageable.ofSize(perPage)).getTotalPages();
    }
}
