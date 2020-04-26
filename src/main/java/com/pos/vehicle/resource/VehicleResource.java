package com.pos.vehicle.resource;

import com.pos.vehicle.dto.Vehicle;
import com.pos.vehicle.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleResource {

    private final VehicleService service;

    public VehicleResource(VehicleService service) {
        this.service = service;
    }

    @PostMapping("/vehicles")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.create(vehicle);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> retrieveAll() {
        return service.retrieveAll();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle retrieve(@PathVariable Long id) {
        return service.retrieve(id);
    }

    @PutMapping("/vehicles/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return service.update(id, vehicle);
    }

    @DeleteMapping("/vehicles/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
