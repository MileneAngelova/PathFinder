package bg.softuni.pathfinder.repositories;

import bg.softuni.pathfinder.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findAllBy();
}
