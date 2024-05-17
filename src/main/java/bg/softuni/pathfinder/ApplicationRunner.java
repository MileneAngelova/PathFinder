package bg.softuni.pathfinder;

import bg.softuni.pathfinder.sevices.SeedRolesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final SeedRolesService seedService;

    public ApplicationRunner(SeedRolesService seedService) {
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedRoles();
    }
}
