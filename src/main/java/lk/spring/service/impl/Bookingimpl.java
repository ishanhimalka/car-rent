package lk.spring.service.impl;

import lk.spring.dto.BookingDTO;
import lk.spring.entity.Booking;
import lk.spring.repo.*;
import lk.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Bookingimpl implements BookingService {
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBook(BookingDTO dto) {
        if (!bookingRepo.existsById(dto.getBookingId())) {
            bookingRepo.save(modelMapper.map(dto, Booking.class));
        } else {
            throw new RuntimeException("This Booking is already Exist!");
        }
    }

    @Override
    public void updateBook(BookingDTO dto) {
        if (bookingRepo.existsById(dto.getBookingId())) {
            bookingRepo.save(modelMapper.map(dto, Booking.class));
        } else {
            throw new RuntimeException("Booking Not Found!");
        }
    }

    @Override
    public BookingDTO searchBook(String bookingId) {
        Optional<Booking> book = bookingRepo.findById(bookingId);
        if (book.isPresent()) {
            return modelMapper.map(book.get(), BookingDTO.class);
        } else {
            throw new RuntimeException("Booking does not exist!");
        }
    }

    @Override
    public void deleteBook(String bookingId) {
        if (bookingRepo.existsById(bookingId)) {
            bookingRepo.deleteById(bookingId);
        } else {
            throw new RuntimeException("Couldn't to Cancel Booking!");
        }
    }

    @Override
    public List<BookingDTO> getAllBook() {
        return modelMapper.map(bookingRepo.findAll(), new TypeToken<List<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void confirmBook(String bookingId) {
        if (bookingRepo.existsById(bookingId)) {
            Optional<Booking> book = bookingRepo.findById(bookingId);
            BookingDTO map = modelMapper.map(book.get(), BookingDTO.class);
            map.setStatus(true);

            Booking map1 = modelMapper.map(map, Booking.class);
            bookingRepo.save(map1);
        }
    }
}
