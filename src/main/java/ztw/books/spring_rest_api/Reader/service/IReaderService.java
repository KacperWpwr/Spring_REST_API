package ztw.books.spring_rest_api.Reader.service;

import ztw.books.spring_rest_api.Reader.dto.ReaderDTO;
import ztw.books.spring_rest_api.Reader.entity.Reader;
import ztw.books.spring_rest_api.Reader.request.CreateReaderRequest;

import java.util.List;
import java.util.Optional;

public interface IReaderService {
    ReaderDTO createReader(CreateReaderRequest request);
    ReaderDTO updateReader(CreateReaderRequest request, long id);
    ReaderDTO getReader(long id);
    List<ReaderDTO> getReaders();
    void deleteReader(long id);

    Optional<Reader> findReader(long id);

}
