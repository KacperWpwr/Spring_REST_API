package ztw.books.spring_rest_api.Author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ztw.books.spring_rest_api.Author.entity.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long> {
}
