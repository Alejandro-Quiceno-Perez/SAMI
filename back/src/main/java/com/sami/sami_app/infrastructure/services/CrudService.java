package com.sami.sami_app.infrastructure.services;

import org.springframework.data.domain.Page;

public interface CrudService  <REQUEST,RESPONSE,TYPE> {
    Page<RESPONSE>getAll(int page, int size);

    RESPONSE create (REQUEST request);
    RESPONSE update (REQUEST request, TYPE id);
    void delete (TYPE id);
    RESPONSE getByID(TYPE id);
    
}
