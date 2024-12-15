package com.olikue.redflags;

import com.olikue.redflags.model.Identifier;
import com.olikue.redflags.repository.IdentifierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class RedflagsApplicationTests {

	@Autowired
	private IdentifierRepository identifierRepository;

	@Test
	void contextLoads() {
		// Example test
		Identifier identifier = new Identifier();
		identifier.setName("TestIdentifier");

		Identifier savedIdentifier = identifierRepository.save(identifier);

		assert savedIdentifier.getId() != null;
		assert identifierRepository.findAll().size() == 1;
	}

}
