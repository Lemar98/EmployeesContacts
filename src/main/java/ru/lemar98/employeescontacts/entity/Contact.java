package ru.lemar98.employeescontacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column
    private String value;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact that)) return false;
        if (!getId().equals(that.getId())) return false;
        if (!getType().equals(that.getType())) return false;
        return getValue().equals(that.getValue());
    }

    @Override
    public final int hashCode() {
        int result = getId().hashCode();
        result = 31 * result * getType().hashCode();
        result = 31 * result * getValue().hashCode();
        return result;
    }

    public enum Type {
        PHONE, EMAIL
    }
}
