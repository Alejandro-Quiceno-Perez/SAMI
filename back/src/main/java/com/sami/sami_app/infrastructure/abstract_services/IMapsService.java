package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.infrastructure.services.CrudService;
import com.sami.sami_app.util.dtos.request.MapsRequest;
import com.sami.sami_app.util.dtos.response.MapsResponse;

interface IMapsService extends CrudService <MapsRequest, MapsResponse,String>{

    
}