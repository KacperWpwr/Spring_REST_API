package ztw.books.spring_rest_api.Reader.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ztw.books.spring_rest_api.Reader.dto.ReaderDTO;
import ztw.books.spring_rest_api.Reader.entity.Reader;
import ztw.books.spring_rest_api.Reader.repository.IReaderRepository;
import ztw.books.spring_rest_api.Reader.request.CreateReaderRequest;
import ztw.books.spring_rest_api.Reader.service.IReaderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService implements IReaderService {
    private final IReaderRepository readerRepository;

    @Override
    public ReaderDTO createReader(CreateReaderRequest request) {
        Reader reader = Reader.builder()
                .name(request.name())
                .lastName(request.lastName())
                .build();

        reader = readerRepository.save(reader);

        return new ReaderDTO(reader.getId(), reader.getName(), reader.getLastName());
    }

    @Override
    public ReaderDTO updateReader(CreateReaderRequest request, long id) {
        Reader reader = readerRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        reader.setName(request.name());
        reader.setLastName(request.lastName());

        reader = readerRepository.save(reader);

        return new ReaderDTO(reader.getId(), reader.getName() , reader.getLastName());
    }

    @Override
    public ReaderDTO getReader(long id) {
        Reader reader = readerRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatusCode.valueOf(404)));

        return new ReaderDTO(reader.getId(), reader.getName() , reader.getLastName());
    }

    @Override
    public List<ReaderDTO> getReaders() {
        return readerRepository.findAll().stream().map(reader ->
                new ReaderDTO(reader.getId(), reader.getName() , reader.getLastName())).toList();
    }

    @Override
    public void deleteReader(long id) {
        Reader reader = readerRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatusCode.valueOf(404)));
        readerRepository.deleteById(id);
    }
}
