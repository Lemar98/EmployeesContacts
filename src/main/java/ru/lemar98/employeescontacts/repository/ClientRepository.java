package ru.lemar98.employeescontacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lemar98.employeescontacts.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
