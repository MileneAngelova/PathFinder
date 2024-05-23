package bg.softuni.pathfinder.repositories;

import bg.softuni.pathfinder.models.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    @Query("select r from Route r Order By size(r.comments) desc")
    List<Route> findMostCommented();

    @Override
    Optional<Route> findById(Long aLong);
}
