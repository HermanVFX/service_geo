package com.example.service_geo.service;

import com.example.service_geo.model.ResponseGeoIp;
import com.maxmind.geoip2.exception.GeoIp2Exception;

import java.io.IOException;

public interface GeoIpService {
    ResponseGeoIp getLocation(String ip) throws IOException, GeoIp2Exception;
}
