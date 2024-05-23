package bg.softuni.pathfinder.sevices.impl;

import bg.softuni.pathfinder.models.dtos.RouteInfoDTO;
import bg.softuni.pathfinder.models.entities.Picture;
import bg.softuni.pathfinder.models.entities.Route;
import bg.softuni.pathfinder.repositories.RouteRepository;
import bg.softuni.pathfinder.sevices.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final Random random;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, Random random, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.random = random;
    }


    @Transactional
    public List<RouteInfoDTO> getAllRoutes() {
        return routeRepository.findAll().stream().map(this::mapToRouteInfo).collect(Collectors.toList());
    }

    private RouteInfoDTO mapToRouteInfo(Route route) {
        RouteInfoDTO infoDto = this.modelMapper.map(route, RouteInfoDTO.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();
        infoDto.setImageUrl(first.get().getUrl());

        return infoDto;
    }

    @Transactional
    public RouteInfoDTO getRandomRoute() {
        long routesCount = this.routeRepository.count();
        Long randomId = this.random.nextLong(routesCount) + 1;

        Optional<Route> optRoute = this.routeRepository.findById(randomId);

        if (optRoute.isEmpty()) {
            throw new RuntimeException("Route  not found!");
        }

        return mapToRouteInfo(optRoute.get());
    }

    @Override
    public List<Route> getMostCommented() {
        return this.routeRepository.findMostCommented();
    }

}
