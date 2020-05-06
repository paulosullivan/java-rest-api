package com.pos.vehicle.datastore.embedded;

import com.pos.vehicle.dto.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MapDataStore implements DataStore<Vehicle> {

    private final Map<Long, Vehicle> vehicles;

    private final IdGenerator idGenerator;

    public MapDataStore() {
        // You can create mutable maps with one line, but they are all ugly IMHO
        vehicles = new HashMap();
        vehicles.put(1L, new Vehicle(1L, "152-T-1234", "Opel", "Astra Hatch", "Red"));
        vehicles.put(2L, new Vehicle(2L, "152-T-1235", "Volkswagon", "Golf Hatch", "Black"));
        idGenerator = new IdGenerator(3L);
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        vehicle.setId(idGenerator.nextId());
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    @Override
    public Collection<Vehicle> retrieveAll() {
        return vehicles.values();
    }

    @Override
    public Vehicle retrieve(Long id) {
        return vehicles.get(id);
    }

    @Override
    public Vehicle update(Long id, Vehicle vehicle) {
        Vehicle foundVehicle = vehicles.get(id);
        foundVehicle.setReg(vehicle.getReg());
        foundVehicle.setColor(vehicle.getColor());
        return foundVehicle;
    }

    @Override
    public void delete(Long id) {
        vehicles.remove(id);
    }
}
