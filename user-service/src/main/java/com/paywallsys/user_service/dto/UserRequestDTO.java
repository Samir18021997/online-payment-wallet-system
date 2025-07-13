package com.paywallsys.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(@NotBlank String name, @NotBlank @Email String email, String phone) {
}
