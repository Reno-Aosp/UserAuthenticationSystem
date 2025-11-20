package my.first.app.Service;

import my.first.app.DTO.UserRegDTO;
import my.first.app.Entity.User;

public interface UserService {
    User registerUser(UserRegDTO registrationDto);
    User findByUsername(String username);
    boolean usernameExists(String username);
}
