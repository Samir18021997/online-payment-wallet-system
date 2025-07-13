package com.paywallsys.user_service.service.impl;

import com.paywallsys.user_service.dto.UserRequestDTO;
import com.paywallsys.user_service.dto.UserResponseDTO;
import com.paywallsys.user_service.exception.UserNotFoundException;
import com.paywallsys.user_service.model.User;
import com.paywallsys.user_service.repository.UserRepository;
import com.paywallsys.user_service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .name(userRequestDTO.name())
                .email(userRequestDTO.email())
                .phone(userRequestDTO.name())
                .build();
        userRepository.save(user);
        return mapToResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapToResponseDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setName(userRequestDTO.name());
        user.setPhone(userRequestDTO.phone());
        userRepository.save(user);
        return mapToResponseDTO(user);
    }

    private UserResponseDTO mapToResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }
}
