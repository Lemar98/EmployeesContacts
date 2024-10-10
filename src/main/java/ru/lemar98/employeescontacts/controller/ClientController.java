package ru.lemar98.employeescontacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lemar98.employeescontacts.dto.ClientDTO;
import ru.lemar98.employeescontacts.dto.ContactDTO;
import ru.lemar98.employeescontacts.dto.CreateClientDTO;
import ru.lemar98.employeescontacts.dto.CreateContactDTO;
import ru.lemar98.employeescontacts.entity.Client;
import ru.lemar98.employeescontacts.entity.Contact;
import ru.lemar98.employeescontacts.mapper.DTOMapper;
import ru.lemar98.employeescontacts.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody CreateClientDTO createClientDTO) {
        Client client = clientService.addClient(createClientDTO.name());
        ClientDTO clientDTO = DTOMapper.mapToClientDto(client);
        return ResponseEntity.ok(clientDTO);
    }

    @PostMapping("/{clientId}/contacts")
    public ResponseEntity<ContactDTO> addContact(
            @PathVariable Long clientId, @RequestBody CreateContactDTO createContactDTO
    ) {
        Contact contact = clientService.addContact(clientId, createContactDTO.typeToEnum(), createContactDTO.value());
        ContactDTO contactDTO = DTOMapper.mapToContactDto(contact);
        return ResponseEntity.ok(contactDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        return ResponseEntity.ok(clientService.getClients().stream().map(DTOMapper::mapToClientDto).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(DTOMapper::mapToClientDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<List<ContactDTO>> getContactsByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(
                clientService.getContactsByClientId(clientId)
                        .stream()
                        .map(DTOMapper::mapToContactDto)
                        .toList()
        );
    }

    @GetMapping("/{clientId}/contacts/{type}")
    public ResponseEntity<List<ContactDTO>> getContactsByClientIdAndType(
            @PathVariable Long clientId, @PathVariable String type
    ) {
        Contact.Type contactType = Contact.Type.valueOf(type.toUpperCase());
        return ResponseEntity.ok(
                clientService.getContactsByClientIdAndType(clientId, contactType)
                        .stream()
                        .map(DTOMapper::mapToContactDto)
                        .toList()
        );
    }
}
