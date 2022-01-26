package com.rckr.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country{
    private String alpha2Code;
    private String alpha3Code;
    private List<String> altSpellings;
    private int area;
    private List<String> borders;
    private List<String> callingCodes;
    private String capital;
    private List<Currency> currencies;
    private String demonym;
    private String flag;
    private double gini;
    private List<Language> languages;
    private List<Double> latlng;
    private String name;
    private String nativeName;
    private String numericCode;
    private int population;
    private String region;
    private List<RegionalBloc> regionalBlocs;
    private String subregion;
    private List<String> timezones;
    private List<String> topLevelDomain;
    private Translations translations;
    private String cioc;
}
