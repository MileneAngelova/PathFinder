package bg.softuni.pathfinder.sevices;

import bg.softuni.pathfinder.models.dtos.LoginDTO;
import bg.softuni.pathfinder.models.dtos.RegisterDTO;

public interface UserService {
    public void register(RegisterDTO registerDTO);

    public void login(LoginDTO loginDTO);

    public void logout();

    public boolean isLoggedIn();

    public boolean isAdmin();

    public boolean userExist(String email, String password);
}
