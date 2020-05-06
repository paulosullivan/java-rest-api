package com.pos.vehicle.service;

import com.pos.vehicle.datastore.embedded.DataStore;
import com.pos.vehicle.dto.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VehicleService {

    private final DataStore<Vehicle> dataStore;

    // Could have omitted the Qualifier annotation, and placed the Primary annotation on the MapDataStore component
    // We can even use both annotations if desired
    // @Primary to define the default, and @Qualifier when we need an override
    public VehicleService(@Qualifier("mapDataStore") DataStore<Vehicle> dataStore) {
        this.dataStore = dataStore;
    }

    public Vehicle create(final Vehicle vehicle) {
        return dataStore.create(vehicle);
    }

    public Collection<Vehicle> retrieveAll() {
        return dataStore.retrieveAll();
    }

    public Vehicle retrieve(final Long id) {
        return dataStore.retrieve(id);
    }

    public Vehicle update(final Long id, final Vehicle vehicle) {
        return dataStore.update(id, vehicle);
    }

    public void delete(final Long id) {
        dataStore.delete(id);
    }

}
