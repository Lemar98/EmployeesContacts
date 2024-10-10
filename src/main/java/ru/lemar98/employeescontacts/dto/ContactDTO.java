package ru.lemar98.employeescontacts.dto;

import lombok.Builder;

@Builder
public record ContactDTO(Long id, String type, String value) {
}
