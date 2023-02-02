package com.example.location.service.impl;

import com.example.location.dao.LocationRepository;
import com.example.location.entity.ParcelCountByLocation;
import com.example.location.service.LocationService;
import com.example.location.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER= LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    LocationRepository repository;

    @Override
    public List<ParcelCountByLocation> getLocationWiseParcelCount() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getAllParcelsByCompaniesRequest");

        List<ParcelCountByLocation> parcelsByLocations = repository.countParcelsByLocation();

        LOGGER.info("getAllParcelsByCompaniesResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByLocations));

        return parcelsByLocations;
    }
}
