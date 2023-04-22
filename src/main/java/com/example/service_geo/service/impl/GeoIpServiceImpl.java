package com.example.service_geo.service.impl;

import com.example.service_geo.model.ResponseGeoIp;
import com.example.service_geo.service.GeoIpService;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class GeoIpServiceImpl implements GeoIpService {

    @Override
    public ResponseGeoIp getLocation(String ip) {
        CityResponse response = null;
        File database = new File("src/main/resources/db/GeoLite2-City.mmdb");
        try {

            DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
            InetAddress ipAddress = InetAddress.getByName(ip);
            response = dbReader.city(ipAddress);
        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }

        String cityName = response.getCity().getName();

        Float latitude = response.getLocation().getLatitude().floatValue();
        Float longitude = response.getLocation().getLongitude().floatValue();

        return new ResponseGeoIp(latitude, longitude, cityName);
    }
}
