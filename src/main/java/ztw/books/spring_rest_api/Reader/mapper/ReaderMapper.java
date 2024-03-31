package ztw.books.spring_rest_api.Reader.mapper;

import org.springframework.stereotype.Component;
import ztw.books.spring_rest_api.Reader.dto.ReaderDTO;
import ztw.books.spring_rest_api.Reader.entity.Reader;

@Component
public class ReaderMapper {


    public ReaderDTO getReaderDTO(Reader reader){
        return new ReaderDTO(reader.getId(), reader.getName(), reader.getLastName());
    }
}
