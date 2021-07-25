package com.sda.goldmann.iss.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.goldmann.iss.client.IssClient;
import com.sda.goldmann.iss.model.Coordinates;
import com.sda.goldmann.iss.model.People;
import com.sda.goldmann.iss.model.Person;
import com.sda.goldmann.iss.model.PositionIss;

import java.util.List;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

public class IssService {

    private static final String ASTROS_URI = "http://api.open-notify.org/astros.json";
    private static final String ISS_NOW = "http://api.open-notify.org/iss-now.json";

    private final IssClient issClient;
    private final ObjectMapper objectMapper;

    public IssService(IssClient issClient, ObjectMapper objectMapper) {
        this.issClient = issClient;
        this.objectMapper = objectMapper;
    }

    public List<Person> getAstronauts() {
        String json = issClient.get(ASTROS_URI);
        return deserializeAstronauts(json);
    }

    private List<Person> deserializeAstronauts(String json) {
        try {
            People people = objectMapper.readValue(json, new TypeReference<People>() {
            });
            return people.getPeople();
        } catch (JsonProcessingException ex) {
            LOGGER.error("failed to deserialize ", ex);
            return List.of();
        }
    }


    public PositionIss getPosition() {
        String json = issClient.get(ISS_NOW);
        return deserializePosition(json);
    }

    private PositionIss deserializePosition(String json) {
        try {
            PositionIss positionIss = objectMapper.readValue(json, new TypeReference<PositionIss>() {
            });
            return positionIss;
        } catch (JsonProcessingException ex) {
            LOGGER.error("failed to deserialize ", ex);
            return null;
        }
    }
}

