package com.sami.sami_app.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class LocationsRequest {

    private Double serviceLatitude;
    private Double serviceLongitude;

    private Double ambulanceLatitude;
    private Double ambulanceLongitude;
    
    private Double hospitalLatitude;
    private Double hospitalLongitude;
    
}
