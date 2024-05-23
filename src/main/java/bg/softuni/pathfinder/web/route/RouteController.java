package bg.softuni.pathfinder.web.route;

import bg.softuni.pathfinder.models.dtos.RouteInfoDTO;
import bg.softuni.pathfinder.sevices.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {
        List<RouteInfoDTO> routes = this.routeService.getAllRoutes();
        model.addAttribute("allRoutes", routes);

        return "routes";
    }
}
