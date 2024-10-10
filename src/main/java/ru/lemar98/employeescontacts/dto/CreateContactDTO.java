package ru.lemar98.employeescontacts.dto;

import ru.lemar98.employeescontacts.entity.Contact;

public record CreateContactDTO(String type, String value) {
    public Contact.Type typeToEnum() {
        return Contact.Type.valueOf(type);
    }
}
