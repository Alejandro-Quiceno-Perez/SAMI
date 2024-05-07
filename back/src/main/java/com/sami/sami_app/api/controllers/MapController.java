package com.sami.sami_app.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.sami.sami_app.api.dto.request.LocationsRequest;


/**
  receives the service, ambulance and hospital locations as a LocationsRequest object. It uses the Google Maps API to get the corresponding addresses from the latitude and longitude coordinates of each location, 
 */

@Controller
public class MapController {


    @Autowired
    private com.google.maps.GeoApiContext geoApiContext;


    @PostMapping("/locations")
    public Map<String, String> getAllLocations(@RequestBody LocationsRequest locationsRequest) {
        //capture of each location in terms of latitude and longitude
        Double serviceLatitude = locationsRequest.getServiceLatitude();
        Double serviceLongitude = locationsRequest.getServiceLongitude();
        Double ambulanceLatitude = locationsRequest.getAmbulanceLatitude();
        Double ambulanceLongitude = locationsRequest.getAmbulanceLongitude();
        Double hospitalLatitude = locationsRequest.getHospitalLatitude();
        Double hospitalLongitude = locationsRequest.getHospitalLongitude();

        //map= key-value mapping            --> <String, String> 
        //HashMap= stores the data as pairs --> for each Entity's location

        Map<String, String> locations = new HashMap<>();
        locations.put("Service", location(serviceLatitude, serviceLongitude));
        locations.put("Ambulance", location(ambulanceLatitude, ambulanceLongitude));
        locations.put("Hospital", location(hospitalLatitude, hospitalLongitude));

        return locations;
    }

    //validated if it received a valid location or if it received any locations
    private String location(Double latitude, Double longitude) {
        try {
            GeocodingResult[] results = GeocodingApi.reverseGeocode(geoApiContext, new com.google.maps.model.LatLng(latitude, longitude)).await();
            if (results.length > 0) {
                return results[0].formattedAddress;
            } else {
                return "No results found";
            }
        } catch (Exception e) {
            return "Error while performing geolocation: " + e.getMessage();
        }
    }
}





