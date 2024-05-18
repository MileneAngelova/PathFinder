package bg.softuni.pathfinder.sevices.impl;

import bg.softuni.pathfinder.models.entities.Route;
import bg.softuni.pathfinder.repositories.RouteRepository;
import bg.softuni.pathfinder.sevices.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> getMostCommented() {
        return this.routeRepository.findMostCommented();
    }
}
