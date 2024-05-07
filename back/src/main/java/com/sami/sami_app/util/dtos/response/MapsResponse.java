package com.sami.sami_app.util.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class MapsResponse {
    private double distanceHospital; 
    private double estimatedTime; 
    
}
