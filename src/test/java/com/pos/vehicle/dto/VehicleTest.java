package com.pos.vehicle.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    public void test() {
        Vehicle vehicle = new Vehicle(1L,"152-T-1234", "Opel", "Astra", "Red");
        assertEquals(1L, vehicle.getId());
        assertEquals("152-T-1234", vehicle.getReg());
        assertEquals("Opel", vehicle.getMake());
        assertEquals("Astra", vehicle.getModel());
        assertEquals("Red", vehicle.getColor());
    }

}
