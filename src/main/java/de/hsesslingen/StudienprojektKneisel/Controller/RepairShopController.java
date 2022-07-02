package de.hsesslingen.StudienprojektKneisel.Controller;

import de.hsesslingen.StudienprojektKneisel.Entities.RepairShop;
import de.hsesslingen.StudienprojektKneisel.Exceptions.RepairShopNotFoundException;
import de.hsesslingen.StudienprojektKneisel.Repositories.RepairShopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/repairShops")
public class RepairShopController {
    private final RepairShopRepository repairShopRepository;
    Logger logger = LoggerFactory.getLogger(RepairShopController.class);

    public RepairShopController(RepairShopRepository repairShopRepository) {
        this.repairShopRepository = repairShopRepository;
    }

    @GetMapping
    public Iterable findAll() {
        logger.info("REST Request for all RepairShops");
        return repairShopRepository.findAll();
    }

    @GetMapping("/{id}")
    public RepairShop findOne(@PathVariable Long id){
        try{
            logger.info("REST Request for repairShop with id {}!", id);
            RepairShop foundRepairShop = repairShopRepository.findById(id).orElseThrow(RepairShopNotFoundException::new);
            logger.info("RepairShop found with id {}!", id);
            return foundRepairShop;
        } catch (RepairShopNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "RepairShop Not Found", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RepairShop create(@RequestBody RepairShop repairShop){
        try{
            RepairShop savedRepairShop = repairShopRepository.save(repairShop);
            logger.info("Created repairShop with id {}!", repairShop.getId());
            return savedRepairShop;
        }catch(InvalidDataAccessApiUsageException | DataIntegrityViolationException e){
            logger.error("Could not create repairShop! {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please provide a valid request to create a repairShop!");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RepairShop update(@PathVariable Long id, @RequestBody RepairShop repairShop){
        try{
            repairShop.setId(id);
            RepairShop updatedRepairShop = repairShopRepository.save(repairShop);
            logger.info("Updated repairShop with id {}!", repairShop.getId());
            return updatedRepairShop;
        }catch(InvalidDataAccessApiUsageException | DataIntegrityViolationException e){
            logger.error("Could not update repairShop! {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Please provide a valid request to update a repairShop!");
        }
    }

    @DeleteMapping("/{id}")
    public void removeRepairShop(@PathVariable("id") Long id){
        logger.info("REST Request to delete repairShop with id {}", id);
        try{
            RepairShop deletableRepairShop = repairShopRepository.findById(id).orElseThrow(RepairShopNotFoundException::new);
            repairShopRepository.delete(deletableRepairShop);
            logger.info("Deletion successful for repairShop with id {}!", id);
        } catch (RepairShopNotFoundException e) {
            logger.error("Could not delete repairShop with id {}!", id);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "RepairShop not found, provide a correct id!", e);
        }
    }
}
