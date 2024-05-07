package com.sami.sami_app.util.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class MapsRequest {
    private double userLatitude;
    private double userLongitude;
    private double ambulanceLatitude;
    private double ambulanceLongitude;
    private double hospitalLatitude;
    private double hospitalLongitude;
    
}
