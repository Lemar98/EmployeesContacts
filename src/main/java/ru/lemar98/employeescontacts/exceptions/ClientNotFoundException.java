package ru.lemar98.employeescontacts.exceptions;

public class ClientNotFoundException extends EmployeesContactsException {
    public ClientNotFoundException(Long id) {
        super("Client with id %s not found!".formatted(id));
    }
}
