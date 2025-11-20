package my.first.app.Service;

import my.first.app.DTO.UserRegDTO;
import my.first.app.Entity.User;
import my.first.app.Repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public User registerUser(UserRegDTO registrationDto) {
        User user = new User();
        user.setName(registrationDto.getName());
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setPhone(registrationDto.getPhone());
        user.setAddress(registrationDto.getAddress());
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        
        return userRepo.save(user);
    }
    
    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }
    
    @Override
    public boolean usernameExists(String username) {
        return userRepo.existsByUsername(username);
    }
}
