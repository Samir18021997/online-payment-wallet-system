package com.paywallsys.user_service.service;

import com.paywallsys.user_service.dto.UserRequestDTO;
import com.paywallsys.user_service.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id);
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
}
