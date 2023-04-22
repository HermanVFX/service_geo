package com.example.service_geo.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGeoIp {

    @NotNull
    private Float latitude;
    @NotNull
    private Float longitude;

    private String city;

}
