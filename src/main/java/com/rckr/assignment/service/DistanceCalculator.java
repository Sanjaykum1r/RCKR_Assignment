package com.rckr.assignment.service;

import com.rckr.assignment.model.Country;
import com.rckr.assignment.model.Currency;
import com.rckr.assignment.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class DistanceCalculator {

    private static final DecimalFormat decFormat = new DecimalFormat("0.00");
    private static final double radius = 6371;
    private Map<String,Country> allDistinctCurrencyCountry;

    @PostConstruct
    public void getAllCountries() throws URISyntaxException, IOException {
        List<Country> countryList = Util.getAllCountries();
        allDistinctCurrencyCountry=new HashMap<>();
        Set<String> repeatedCurrency=new HashSet<>();
        for(Country country: countryList){
            List<Currency> currencyList=country.getCurrencies();
            for(Currency currency:currencyList) {
                if (allDistinctCurrencyCountry.containsKey(currency.getName()))
                    repeatedCurrency.add(currency.getName());
                else
                    allDistinctCurrencyCountry.put(currency.getName(), country);
            }
        }
        allDistinctCurrencyCountry.keySet().removeAll(repeatedCurrency);
        for(Map.Entry<String,Country> vals:allDistinctCurrencyCountry.entrySet()){
            log.info("The currency is {} and country is {}",vals.getKey(),vals.getValue().getName());
        }
    }

    public String calculateDistance(long population,int maxVal){
        List<Country> finalList=getFinalCountryList(population,maxVal);
        double finalAns=0;
        for(int index=0;index<maxVal && index<finalList.size() ;++index){
            Country country1= finalList.get(index);
            log.info("Indexed country is {} with population {}",country1.getName(),country1.getPopulation());
            for(int findWith=index+1;findWith<maxVal && findWith < finalList.size() ;++findWith){
                Country country2= finalList.get(findWith);
                finalAns+=getDistance(country1,country2);
            }
        }
        return decFormat.format(finalAns);
    }

    private double getDistance(Country country1, Country country2) {
        double lat1=0,lat2=0,lon1=0,lon2=0;
        if(country1.getLatlng()!=null && country1.getLatlng().size()>0){
            lat1=country1.getLatlng().get(0);
            if(country1.getLatlng().size()==2){
                lon1=country1.getLatlng().get(1);
            }
        }
        if(country2.getLatlng()!=null && country2.getLatlng().size()>0){
            lat2=country2.getLatlng().get(0);
            if(country2.getLatlng().size()==2){
                lon2=country2.getLatlng().get(1);
            }
        }
        double distance = distance(lat1,lat2,lon1,lon2);
        log.info("Distance between {} and {} is {}",country1.getName(),country2.getName(),distance);
        return distance;
    }

    private List<Country> getFinalCountryList(long population, int maxVal) {
        log.info("Size of the map is {}",allDistinctCurrencyCountry.size());
        return allDistinctCurrencyCountry.values().stream().
                sorted(Comparator.comparing(Country::getPopulation)).
                filter(country->country.getPopulation()>=population).
                limit(maxVal).
                collect(Collectors.toList());
    }

    private double distance(double lat1,double lat2, double lon1,double lon2){

        decFormat.setRoundingMode(RoundingMode.DOWN);
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double arc = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(arc));
        return Double.parseDouble(decFormat.format(radius*c));
    }
}
