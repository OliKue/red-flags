package com.olikue.redflags.controller;

import com.olikue.redflags.model.Identifier;
import com.olikue.redflags.repository.IdentifierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class IdentifierControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private IdentifierRepository identifierRepository;

    @Test
    void testCreateAndRetrieveIdentifier() {
        Identifier newIdentifier = new Identifier();
        newIdentifier.setName("TestIdentifier");

        ResponseEntity<Identifier> response = restTemplate.postForEntity("/api/identifiers", newIdentifier, Identifier.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

        List<Identifier> identifiers = identifierRepository.findAll();
        assertThat(identifiers).hasSize(1);
        assertThat(identifiers.getFirst().getName()).isEqualTo("TestIdentifier");
    }
}

