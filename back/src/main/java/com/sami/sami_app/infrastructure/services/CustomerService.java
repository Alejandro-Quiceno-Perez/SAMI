package com.sami.sami_app.infrastructure.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
 

import com.sami.sami_app.domain.repositories.CustomerRepository;
import com.sami.sami_app.infrastructure.abstract_services.ICustomerService;
import com.sami.sami_app.util.dtos.request.CustomerRequest;
import com.sami.sami_app.util.dtos.response.CustomerResponse;

public class CustomerService implements ICustomerService {

     @Autowired
    private final CustomerRepository customerRepository;
    @Override
    public Page<CustomerResponse> getAll(int page, int size) {
      
    }

    @Override
    public CustomerResponse create(CustomerRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CustomerResponse update(CustomerRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CustomerResponse getByID(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }
    

}
