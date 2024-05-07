package com.sami.sami_app.util.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private String Useremail;
    private String Userpassword;
    private String UserFirstName;
    private String UserLastName;
    private String UserPhone;
    private String UserRhType;
}
