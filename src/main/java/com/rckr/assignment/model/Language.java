package com.rckr.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language {
    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;
}
