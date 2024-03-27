package ztw.books.spring_rest_api.Reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ztw.books.spring_rest_api.Reader.entity.Reader;

@Repository
public interface IReaderRepository extends JpaRepository<Reader,Long> {
}
