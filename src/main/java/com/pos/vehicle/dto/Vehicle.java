package com.pos.vehicle.dto;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private Long id;

    @NonNull
    private String reg;

    @NonNull
    private String make;

    @NonNull
    private String model;

    @NonNull
    private String color;

}
