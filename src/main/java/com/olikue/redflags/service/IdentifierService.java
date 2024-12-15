package com.olikue.redflags.service;

import com.olikue.redflags.model.Identifier;
import com.olikue.redflags.repository.IdentifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IdentifierService {

    private final IdentifierRepository identifierRepository;

    @Autowired
    public IdentifierService(IdentifierRepository identifierRepository) {
        this.identifierRepository = identifierRepository;
    }

    public List<Identifier> getAllIdentifiers() {
        return identifierRepository.findAll();
    }

    public Identifier getIdentifierById(UUID id) {
        return identifierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Identifier not found"));
    }

    public Identifier createIdentifier(Identifier identifier) {
        return identifierRepository.save(identifier);
    }

    public void deleteIdentifier(UUID id) {
        identifierRepository.deleteById(id);
    }
}

