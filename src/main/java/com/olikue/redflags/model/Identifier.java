package com.olikue.redflags.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Identifier {

    @Id
    @GeneratedValue
    private UUID id; // Unique identifier

    @Column(nullable = false, unique = true)
    private String name; // Human-readable identifier name

    @Column(nullable = false)
    private boolean flagA; // Example flag

    @Column(nullable = false)
    private boolean flagB; // Another flag

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlagA() {
        return flagA;
    }

    public void setFlagA(boolean flagA) {
        this.flagA = flagA;
    }

    public boolean isFlagB() {
        return flagB;
    }

    public void setFlagB(boolean flagB) {
        this.flagB = flagB;
    }
}