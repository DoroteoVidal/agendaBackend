package com.system.contactbackend.systemcontactbackend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DTOContactRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Email(message = "El email no es valido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    public DTOContactRequest() {}

    public DTOContactRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
