package bg.softuni.pathfinder.web.user;

import bg.softuni.pathfinder.models.entities.Route;
import bg.softuni.pathfinder.sevices.RouteService;
import bg.softuni.pathfinder.sevices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final UserService userService;
   private final RouteService routeService;

    public HomeController(UserService userService, RouteService routeService) {
        this.userService = userService;
        this.routeService = routeService;
    }

    @GetMapping("/")
    @Transactional
    public String index(Model model) {
        List<Route> routes = routeService.getMostCommented();
        model.addAttribute("mostCommented", routes.get(0));
        return"/index";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "/about";
    }
}
