package ztw.books.spring_rest_api.Rental.mapper;

import org.springframework.stereotype.Component;
import ztw.books.spring_rest_api.Rental.dto.RentalDTO;
import ztw.books.spring_rest_api.Rental.entity.Rental;

@Component
public class RentalMapper {

    public RentalDTO getRentalDTO(Rental rental){
        return new RentalDTO(rental.getId(),rental.getBook().getId() ,rental.getReader().getId());
    }
}
