package ru.lemar98.employeescontacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lemar98.employeescontacts.entity.Client;
import ru.lemar98.employeescontacts.entity.Contact;
import ru.lemar98.employeescontacts.exceptions.ClientNotFoundException;
import ru.lemar98.employeescontacts.repository.ClientRepository;
import ru.lemar98.employeescontacts.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
    }

    public Client addClient(String name) {
        Client client = new Client();
        client.setName(name);
        return clientRepository.save(client);
    }

    public Contact addContact(Long clientId, Contact.Type contactType, String value) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        Contact contact = new Contact();
        contact.setClient(client);
        contact.setType(contactType);
        contact.setValue(value);
        return contactRepository.save(contact);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Contact> getContactsByClientId(Long clientId) {
        return contactRepository.findByClientId(clientId);
    }

    public List<Contact> getContactsByClientIdAndType(Long clientId, Contact.Type contactType) {
        return contactRepository.findByClientIdAndType(clientId, contactType);
    }
}
