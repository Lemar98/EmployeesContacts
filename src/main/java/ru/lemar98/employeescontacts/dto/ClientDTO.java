package ru.lemar98.employeescontacts.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ClientDTO(Long id, String name, List<ContactDTO> contacts) {
}
