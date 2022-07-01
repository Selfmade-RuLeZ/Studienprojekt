package de.hsesslingen.StudienprojektKneisel.Controller;

import de.hsesslingen.StudienprojektKneisel.Entities.Car;
import de.hsesslingen.StudienprojektKneisel.Exceptions.CarNotFoundException;
import de.hsesslingen.StudienprojektKneisel.Repositories.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarRepository carRepository;
    Logger logger = LoggerFactory.getLogger(CarController.class);

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public Iterable findAll() {
        logger.info("REST Request for all Cars");
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car findOne(@PathVariable Long id){
        try{
            logger.info("REST Request for car with id {}!", id);
            Car foundCar = carRepository.findById(id).orElseThrow(CarNotFoundException::new);
            logger.info("Car found with id {}!", id);
            return foundCar;
        } catch (CarNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Car Not Found", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody Car car){
        try{
            Car savedCar = carRepository.save(car);
            logger.info("Created car with id {}!", car.getId());
            return savedCar;
        }catch(InvalidDataAccessApiUsageException | DataIntegrityViolationException e){
            logger.error("Could not create car! {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please provide a valid request to create a car!");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car update(@PathVariable Long id, @RequestBody Car car){
        try{
            car.setId(id);
            Car updatedCar = carRepository.save(car);
            logger.info("Updated car with id {}!", car.getId());
            return updatedCar;
        }catch(InvalidDataAccessApiUsageException | DataIntegrityViolationException e){
            logger.error("Could not update car! {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please provide a valid request to update a car!");
        }
    }

    @DeleteMapping("/{id}")
    public void removeCar(@PathVariable("id") Long id){
        logger.info("REST Request to delete car with id {}", id);
        try{
            Car deletableCar = carRepository.findById(id).orElseThrow(CarNotFoundException::new);
            carRepository.delete(deletableCar);
            logger.info("Deletion successful for car with id {}!", id);
        } catch (CarNotFoundException e) {
            logger.error("Could not delete car with id {}!", id);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Car not found, provide a correct id!", e);
        }
    }


}
