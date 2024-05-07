package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.infrastructure.services.CrudService;
import com.sami.sami_app.util.dtos.request.CustomerRequest;
import com.sami.sami_app.util.dtos.response.CustomerResponse;

public interface ICustomerService  extends CrudService<CustomerRequest,CustomerResponse,String>{
    
}
