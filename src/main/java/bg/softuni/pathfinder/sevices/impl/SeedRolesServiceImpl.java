package bg.softuni.pathfinder.sevices.impl;

import bg.softuni.pathfinder.models.entities.Role;
import bg.softuni.pathfinder.models.enums.RoleNameEnum;
import bg.softuni.pathfinder.repositories.RoleRepository;
import bg.softuni.pathfinder.sevices.SeedRolesService;
import org.springframework.stereotype.Service;

@Service
public class SeedRolesServiceImpl implements SeedRolesService {
    private final RoleRepository roleRepository;

    public SeedRolesServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRoles() {
        if (this.roleRepository.count() == 0) {
            for (RoleNameEnum roleName : RoleNameEnum.values()) {
                Role role = new Role();
                role.setName(roleName);
                this.roleRepository.save(role);
            }
        }
    }
}
