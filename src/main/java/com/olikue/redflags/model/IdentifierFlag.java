package com.olikue.redflags.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "identifier_flag")
public class IdentifierFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String identifierFlag;

    @ManyToOne
    @JoinColumn(name = "identifier_id", nullable = false)
    private Identifier identifier;

    @ManyToOne
    @JoinColumn(name = "flag_id", nullable = false)
    private Flag flag;

    @Column(nullable = false)
    private Boolean isEnabled;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getIdentifierFlag() {
        return identifierFlag;
    }

    public void setIdentifierFlag(String identifierFlag) {
        this.identifierFlag = identifierFlag;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

