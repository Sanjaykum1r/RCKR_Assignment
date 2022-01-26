package com.rckr.assignment.controller;

import com.rckr.assignment.service.DistanceCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class DistanceController {

    private final DistanceCalculator distanceCalculator;

    public String getStarted(){
        return "Welcome to Distance Calculator";
    }

    @GetMapping("/getDistance")
    public String getDistance(@RequestParam long population,@RequestParam int maxInput){
        return distanceCalculator.calculateDistance(population,maxInput);
    }


}
