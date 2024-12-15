package com.olikue.redflags;

import com.olikue.redflags.model.Flag;
import com.olikue.redflags.model.Identifier;
import com.olikue.redflags.model.IdentifierFlag;
import com.olikue.redflags.repository.FlagRepository;
import com.olikue.redflags.repository.IdentifierFlagRepository;
import com.olikue.redflags.repository.IdentifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
public class HelloController {

    @Autowired
    private IdentifierRepository identifierRepository;

    @Autowired
    private FlagRepository flagRepository;

    @Autowired
    private IdentifierFlagRepository identifierFlagRepository;


    private final Random rng = new Random();

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/rndId")
    public Identifier randomIdentifier() {
        Identifier rndId = new Identifier();
        rndId.setName("RandomName" + rng.nextInt());

        return identifierRepository.save(rndId);
    }

    @GetMapping("/rndFlag")
    public Flag randomFlag() {
        int randomInt = rng.nextInt();
        Flag featureFlag = new Flag();
        featureFlag.setName("feature_" + randomInt);
        featureFlag.setDescription("Description for feature_" + randomInt);
        featureFlag.setGlobalDefault(rng.nextBoolean());
        return flagRepository.save(featureFlag);
    }

    @GetMapping("/rndIdFlag")
    public IdentifierFlag randomidentifierFlag() {
        Identifier id = identifierRepository.findAll().getLast();
        Flag flag = flagRepository.findAll().getLast();

        IdentifierFlag identifierFlag = new IdentifierFlag();
        identifierFlag.setFlag(flag);
        identifierFlag.setIdentifier(id);
        identifierFlag.setEnabled(rng.nextBoolean());

        return identifierFlagRepository.save(identifierFlag);
    }

}