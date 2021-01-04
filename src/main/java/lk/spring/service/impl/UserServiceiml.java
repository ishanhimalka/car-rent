package lk.spring.service.impl;

import lk.spring.dto.UserDTO;
import lk.spring.entity.User;
import lk.spring.repo.UserRepo;
import lk.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceiml implements UserService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    @Override
    public void saveUser(UserDTO dto) {
        if (!userRepo.existsById(dto.getUsername())) {
            userRepo.save(modelMapper.map(dto, User.class));
        } else {
            throw new RuntimeException("User Already Exist!");
        }
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUsername())) {
            userRepo.save(modelMapper.map(dto, User.class));
        } else {
            throw new RuntimeException("User Not Found!");
        }
    }

    @Override
    public UserDTO searchUser(String username) {
        Optional<User> user = userRepo.findById(username);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDTO.class);
        } else {
            throw new RuntimeException("User does not exist!");
        }
    }

    @Override
    public void deleteUser(String username) {
        if (userRepo.existsById(username)) {
            userRepo.deleteById(username);
        } else {
            throw new RuntimeException("Couldn't to delete User!");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepo.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Override
    public boolean userLogin(String username, String pass) {
        if (userRepo.existsById(username) & userRepo.existsById(pass)) {
            System.out.println("found");
        }
        return false;
    }
}
