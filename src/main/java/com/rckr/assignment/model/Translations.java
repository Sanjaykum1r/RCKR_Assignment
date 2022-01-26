package com.rckr.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Translations {
    private String br;
    private String de;
    private String es;
    private String fa;
    private String fr;
    private String hr;
    private String it;
    private String ja;
    private String nl;
    private String pt;
}
