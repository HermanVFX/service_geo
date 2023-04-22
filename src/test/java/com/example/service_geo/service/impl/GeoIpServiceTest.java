package com.example.service_geo.service.impl;

import com.example.service_geo.model.ResponseGeoIp;
import com.example.service_geo.service.GeoIpService;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeoIpServiceTest {

    private final String IP = "46.242.8.104";
    private final ResponseGeoIp response = new ResponseGeoIp(
            (float) 55.7483,
            (float) 37.6171,
            "Moscow");

    @Autowired
    private GeoIpService geoIpService;

    @Test
    void getLocation() throws IOException, GeoIp2Exception {
        ResponseGeoIp responseFromMethod = geoIpService.getLocation(IP);

        assertEquals(responseFromMethod, response);
    }
}