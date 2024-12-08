package com.olikue.redflags.controller;

import com.olikue.redflags.model.Identifier;
import com.olikue.redflags.service.IdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/identifiers")
public class IdentifierController {

    private final IdentifierService identifierService;

    @Autowired
    public IdentifierController(IdentifierService identifierService) {
        this.identifierService = identifierService;
    }

    @GetMapping
    public List<Identifier> getAllIdentifiers() {
        return identifierService.getAllIdentifiers();
    }

    @GetMapping("/{id}")
    public Identifier getIdentifierById(@PathVariable UUID id) {
        return identifierService.getIdentifierById(id);
    }

    @PostMapping
    public Identifier createIdentifier(@RequestBody Identifier identifier) {
        return identifierService.createIdentifier(identifier);
    }

    @PutMapping("/{id}/flags")
    public Identifier updateFlags(@PathVariable UUID id, @RequestParam boolean flagA, @RequestParam boolean flagB) {
        return identifierService.updateFlags(id, flagA, flagB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdentifier(@PathVariable UUID id) {
        identifierService.deleteIdentifier(id);
        return ResponseEntity.noContent().build();
    }
}

