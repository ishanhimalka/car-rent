package lk.spring.service;

import lk.spring.dto.BookingReturnDTO;

import java.util.List;

public interface BookingReturnService {
    void saveBookReturn(BookingReturnDTO dto);

    void updateBookReturn(BookingReturnDTO dto);

    BookingReturnDTO searchBookReturn(String Invoice);

    void deleteBookReturn(String Invoice);

    List<BookingReturnDTO> getAllBookReturns();
}
