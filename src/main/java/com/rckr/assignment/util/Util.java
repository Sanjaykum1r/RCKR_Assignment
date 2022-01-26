package com.rckr.assignment.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rckr.assignment.model.Country;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
public class Util {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static List<Country> getAllCountries() throws URISyntaxException, IOException {
        URI jsonUrl = new URI("https://cdn.jsdelivr.net/gh/apilayer/restcountries@3dc0fb110cd97bce9ddf27b3e8e1f7fbe115dc3c/src/main/resources/countriesV2.json");
        List<Country> countryList=objectMapper.readValue(jsonUrl.toURL(),new TypeReference<List<Country>>(){});
        log.info("printing all the country list {}",countryList);
        return countryList;
    }
}
