package lk.spring.service.impl;

import lk.spring.dto.BookingReturnDTO;
import lk.spring.entity.BookingReturn;
import lk.spring.repo.BookingRepo;
import lk.spring.repo.BookingReturnRepo;
import lk.spring.service.BookingReturnService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingReturnimpl implements BookingReturnService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookingReturnRepo bookingReturnRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Override
    public void saveBookReturn(BookingReturnDTO dto) {
        if (!bookingReturnRepo.existsById(dto.getInvoice())) {
            bookingReturnRepo.save(modelMapper.map(dto, BookingReturn.class));
        } else {
            throw new RuntimeException("Try Again");
        }
    }

    @Override
    public void updateBookReturn(BookingReturnDTO dto) {
        if (bookingReturnRepo.existsById(dto.getInvoice())) {
            bookingReturnRepo.save(modelMapper.map(dto, BookingReturn.class));
        } else {
            throw new RuntimeException("Booking Not Found!");
        }
    }

    @Override
    public BookingReturnDTO searchBookReturn(String Invoice) {
        Optional<BookingReturn> book = bookingReturnRepo.findById(Invoice);
        if (book.isPresent()) {
            return modelMapper.map(book.get(), BookingReturnDTO.class);
        } else {
            throw new RuntimeException("Booking does not exist!");
        }
    }

    @Override
    public void deleteBookReturn(String Invoice) {
        if (bookingReturnRepo.existsById(Invoice)) {
            bookingReturnRepo.deleteById(Invoice);
        } else {
            throw new RuntimeException("Couldn't to delete Booking!");
        }
    }

    @Override
    public List<BookingReturnDTO> getAllBookReturns() {
        return modelMapper.map(bookingReturnRepo.findAll(), new TypeToken<List<BookingReturnDTO>>() {
        }.getType());
    }
}
