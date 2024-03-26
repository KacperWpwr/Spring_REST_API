package ztw.books.spring_rest_api.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ztw.books.spring_rest_api.Book.enitity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
