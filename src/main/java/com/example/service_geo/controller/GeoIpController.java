package com.example.service_geo.controller;

import com.example.service_geo.model.ResponseGeoIp;
import com.example.service_geo.service.GeoIpService;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GeoIpController {

    private final GeoIpService service;

    @ResponseBody
    @RequestMapping(value = "/api/v1/location", method = RequestMethod.GET)
    public ResponseEntity<ResponseGeoIp> getLocationByIp(@RequestParam("ip_address") String ip)
            throws IOException, GeoIp2Exception {
        return new ResponseEntity<>(service.getLocation(ip), HttpStatus.OK);
    }
}
