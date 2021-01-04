package lk.spring.service;

import lk.spring.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO dto);

    void updateUser(UserDTO dto);

    UserDTO searchUser(String username);

    void deleteUser(String username);

    List<UserDTO> getAllUsers();

    boolean userLogin(String username, String pass);
}
