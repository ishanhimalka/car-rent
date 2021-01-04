package lk.spring.service;

import lk.spring.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void saveBook(BookingDTO dto);

    void updateBook(BookingDTO dto);

    BookingDTO searchBook(String bookingId);

    void deleteBook(String bookingId);

    List<BookingDTO> getAllBook();

    void confirmBook(String bookingId);
}
