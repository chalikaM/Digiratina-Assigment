package com.example.location.controller;

import com.example.location.entity.ParcelCountByLocation;
import com.example.location.service.LocationService;
import com.example.location.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private static final Logger LOGGER= LoggerFactory.getLogger(LocationController.class);

    @Autowired
    LocationService service;

    @GetMapping()
    public List<ParcelCountByLocation> getParcelCountByLocation(){

        long startTime = System.currentTimeMillis();
        LOGGER.info("getParcelCountByLocationRequest");

        List<ParcelCountByLocation> parcelsByLocations = service.getLocationWiseParcelCount();

        LOGGER.info("getParcelCountByLocationResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByLocations));

        return parcelsByLocations;

    }


}
