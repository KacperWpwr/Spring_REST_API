package ztw.books.spring_rest_api.Rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ztw.books.spring_rest_api.Reader.entity.Reader;
import ztw.books.spring_rest_api.Rental.entity.Rental;

import java.util.List;

@Repository
public interface IRentalRepository extends JpaRepository<Rental,Long> {

    @Query("select s from Rental as s where s.book.id=:bookId")
    Rental getRentalByBook(long bookId);

    @Query("select s from Rental as s where s.reader.id=:readerId")
    List<Rental> getRentalByReader(long readerId);
}
