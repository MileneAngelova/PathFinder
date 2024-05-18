package bg.softuni.pathfinder.sevices.impl;

import bg.softuni.pathfinder.session.CurrentUser;
import bg.softuni.pathfinder.models.dtos.LoginDTO;
import bg.softuni.pathfinder.models.dtos.RegisterDTO;
import bg.softuni.pathfinder.models.entities.User;
import bg.softuni.pathfinder.repositories.UserRepository;
import bg.softuni.pathfinder.sevices.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            throw new RuntimeException("Passwords should match");
        }

        Optional<User> optUser = this.userRepository.findByEmailAndPassword(registerDTO.getEmail(), registerDTO.getPassword());

        if (optUser.isEmpty()) {
            User newUser = this.modelMapper.map(registerDTO, User.class);
            this.userRepository.save(newUser);
        }
    }

    @Override
    public void login(LoginDTO loginDTO) {
        this.currentUser.setUsername(loginDTO.getUsername());
    }

    @Override
    public boolean isLoggedIn() {
        return currentUser.getUsername() != null;
    }

    @Override
    public void logout() {
        currentUser.logout();
    }

    @Override
    public boolean isAdmin() {
        return currentUser.isAdmin();
    }

    @Override
    public boolean userExist(String email, String password) {
        RegisterDTO registerDTO = new RegisterDTO();
        Optional<User> optUser = this.userRepository.findByEmailAndPassword(registerDTO.getEmail(), registerDTO.getPassword());
        return optUser.isPresent();
    }
}
