package com.sda.goldmann.iss.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sda.goldmann.iss.client.IssClient;
import com.sda.goldmann.iss.dto.People;
import com.sda.goldmann.iss.dto.Person;
import com.sda.goldmann.iss.dto.Position;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IssServiceImpl implements IssService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IssServiceImpl.class);

    private final String astrosUri;
    private final String issPositionUri;

    private final IssClient issClient;
    private final ObjectMapper objectMapper;

    @Inject
    public IssServiceImpl(
            IssClient issClient,
            ObjectMapper objectMapper,
            @Named("AstrosURL") String astrosUri,
            @Named("IssPositionURL") String issPositionUri
    ) {
        this.issClient = issClient;
        this.objectMapper = objectMapper;
        this.astrosUri = astrosUri;
        this.issPositionUri = issPositionUri;
    }

    public List<Person> getAstronauts() {
        String json = issClient.get(astrosUri);

        return deserializeAstronauts(json);
    }

    private List<Person> deserializeAstronauts(String json) {
        try {
            var people = objectMapper.readValue(json, new TypeReference<People>() {});

            return people.getPeople();
        } catch (JsonProcessingException ex) {
            LOGGER.error("Failed to deserialize", ex);
            return List.of();
        }
    }

    public Position getIssPosition() {
        String json = issClient.get(issPositionUri);

        return deserializePosition(json);
    }

    private Position deserializePosition(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<Position>() {
            });
        } catch (JsonProcessingException ex) {
            LOGGER.error("Failed to deserialize", ex);
            return null;
        }
    }

}
