package bg.softuni.pathfinder.session;

import bg.softuni.pathfinder.models.entities.Role;
import bg.softuni.pathfinder.models.entities.User;
import bg.softuni.pathfinder.models.enums.RoleNameEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String username;

    private Role role;

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }


    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public void logout() {
        this.id = null;
        this.username = null;
    }

    public boolean isAdmin() {
        return this.role.getName().equals(RoleNameEnum.ADMIN);
    }

    public Role getRole() {
        return role;
    }
}
