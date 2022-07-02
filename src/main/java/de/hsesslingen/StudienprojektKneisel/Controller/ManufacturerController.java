package de.hsesslingen.StudienprojektKneisel.Controller;

import de.hsesslingen.StudienprojektKneisel.Entities.Manufacturer;
import de.hsesslingen.StudienprojektKneisel.Exceptions.ManufacturerNotFoundException;
import de.hsesslingen.StudienprojektKneisel.Repositories.ManufacturerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    private final ManufacturerRepository manufacturerRepository;
    Logger logger = LoggerFactory.getLogger(ManufacturerController.class);

    public ManufacturerController(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @GetMapping
    public Iterable findAll() {
        logger.info("REST Request for all Manufacturer");
        return manufacturerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Manufacturer findOne(@PathVariable Long id){
        try{
            logger.info("REST Request for manufacturer with id {}!", id);
            Manufacturer foundManufacturer = manufacturerRepository.findById(id).orElseThrow(ManufacturerNotFoundException::new);
            logger.info("Manufacturer found with id {}!", id);
            return foundManufacturer;
        } catch (ManufacturerNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Manufacturer Not Found", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manufacturer create(@RequestBody Manufacturer manufacturer){
        try{
            Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);
            logger.info("Created manufacturer with id {}!", manufacturer.getId());
            return savedManufacturer;
        }catch(InvalidDataAccessApiUsageException | DataIntegrityViolationException e){
            logger.error("Could not create manufacturer! {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please provide a valid request to create a manufacturer!");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Manufacturer update(@PathVariable Long id, @RequestBody Manufacturer manufacturer){
        try{
            manufacturer.setId(id);
            Manufacturer updatedManufacturer = manufacturerRepository.save(manufacturer);
            logger.info("Updated manufacturer with id {}!", manufacturer.getId());
            return updatedManufacturer;
        }catch(InvalidDataAccessApiUsageException | DataIntegrityViolationException e){
            logger.error("Could not update manufacturer! {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please provide a valid request to update a manufacturer!");
        }
    }

    @DeleteMapping("/{id}")
    public void removeManufacturer(@PathVariable("id") Long id){
        logger.info("REST Request to delete manufacturer with id {}", id);
        try{
            Manufacturer deletableManufacturer = manufacturerRepository.findById(id).orElseThrow(ManufacturerNotFoundException::new);
            manufacturerRepository.delete(deletableManufacturer);
            logger.info("Deletion successful for manufacturer with id {}!", id);
        } catch (ManufacturerNotFoundException e) {
            logger.error("Could not delete manufacturer with id {}!", id);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Manufacturer not found, provide a correct id!", e);
        }
    }

}
