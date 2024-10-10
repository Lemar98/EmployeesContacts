package ru.lemar98.employeescontacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lemar98.employeescontacts.entity.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByClientId(Long clientId);
    List<Contact> findByClientIdAndType(Long clientId, Contact.Type contactType);
}
