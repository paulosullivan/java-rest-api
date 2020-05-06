package com.pos.vehicle.datastore.embedded;

import com.pos.vehicle.dto.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetDataStore implements DataStore<Vehicle> {

    private final Set<Vehicle> vehicles = new HashSet(Arrays.asList(
            new Vehicle(1L, "152-T-1234", "Opel", "Astra Hatch", "Red"),
            new Vehicle(2L, "152-T-1235", "Volkswagon", "Golf Hatch", "Black")
    ));

    private final IdGenerator idGenerator = new IdGenerator(3L);

    public Vehicle create(final Vehicle vehicle) {
        vehicle.setId(idGenerator.nextId());
        vehicles.add(vehicle);
        return vehicle;
    }

    public Set<Vehicle> retrieveAll() {
        return vehicles;
    }

    public Vehicle retrieve(final Long id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Vehicle not found."));
    }

    public Vehicle update(final Long id, final Vehicle vehicle) {
        Vehicle foundVehicle = retrieve(id);
        foundVehicle.setReg(vehicle.getReg());
        foundVehicle.setColor(vehicle.getColor());
        return foundVehicle;
    }

    public void delete(final Long id) {
        vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

}
