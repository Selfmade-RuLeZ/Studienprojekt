package de.hsesslingen.StudienprojektKneisel.Repositories;

import de.hsesslingen.StudienprojektKneisel.Entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}