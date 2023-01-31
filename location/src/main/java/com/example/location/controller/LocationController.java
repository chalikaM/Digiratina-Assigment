package com.example.location.controller;

import com.example.location.dao.LocationRepository;
import com.example.location.entity.ParcelCountByLocation;
import com.example.location.service.LocationService;
import com.example.location.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private static final Logger LOGGER= LoggerFactory.getLogger(LocationController.class);

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    @GetMapping("/get")
    public List<ParcelCountByLocation> findAllParcelsByLocation(){

        long startTime = System.currentTimeMillis();
        LOGGER.info("findAllParcelsByLocationRequest");

        List<ParcelCountByLocation> parcelsByLocations = locationService.getAllParcelsByLocation();

        LOGGER.info("findAllParcelsByLocationResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByLocations));

        return parcelsByLocations;

    }


}
