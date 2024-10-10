package ru.lemar98.employeescontacts.mapper;

import ru.lemar98.employeescontacts.dto.ClientDTO;
import ru.lemar98.employeescontacts.dto.ContactDTO;
import ru.lemar98.employeescontacts.entity.Client;
import ru.lemar98.employeescontacts.entity.Contact;

import java.util.stream.Collectors;

public class DTOMapper {
    public static ClientDTO mapToClientDto(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .contacts(client.getContacts().stream().map(DTOMapper::mapToContactDto).collect(Collectors.toList()))
                .build();
    }

    public static ContactDTO mapToContactDto(Contact contact) {
        return ContactDTO.builder()
                .id(contact.getId())
                .type(contact.getType().name())
                .value(contact.getValue())
                .build();
    }
}
