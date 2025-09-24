package com.ogulcanonder.crud_example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DtoEmployee {

    private Long id;
    private String name;
    private String surname;
    @NotBlank(message = "Email Boş Olamaz")
    @Email(message = "Geçerli Bir Email Giriniz")
    private String email;
    private String phoneNumber;
}
