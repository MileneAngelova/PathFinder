package bg.softuni.pathfinder.sevices;

import bg.softuni.pathfinder.models.dtos.RouteInfoDTO;
import bg.softuni.pathfinder.models.entities.Route;

import java.util.List;

public interface RouteService {
    public List<RouteInfoDTO> getAllRoutes();
    public RouteInfoDTO getRandomRoute();
    public List<Route> getMostCommented();
}
