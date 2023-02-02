package com.example.parcel.service.impl;

import com.example.parcel.dao.ParcelRepository;
import com.example.parcel.entity.Parcel;
import com.example.parcel.entity.ParcelByCompany;
import com.example.parcel.entity.ParcelByLocation;
import com.example.parcel.service.ParcelService;
import com.example.parcel.util.CommonUtil;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {

    private static final Logger LOGGER= LoggerFactory.getLogger(ParcelServiceImpl.class);

    @Value("${company.service.parcel.url}")
    private String endpointForCompanies;

    @Value("${location.service.parcel.url}")
    private String endpointForLocations;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ParcelRepository parcelRepository;

    @CircuitBreaker(name = "parcelByCompanyCircuitBreaker", fallbackMethod = "getCompanyWiseParcelCountFallback")
    @Override
    public List<ParcelByCompany> getCompanyWiseParcelCount(){

        long startTime = System.currentTimeMillis();
        LOGGER.info("getCompanyWiseParcelCountRequest");

        ResponseEntity<ParcelByCompany[]> response = restTemplate.getForEntity(endpointForCompanies, ParcelByCompany[].class);

        LOGGER.info("getCompanyWiseParcelCountResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(response));


        return Arrays.asList(response.getBody());
    }

    @CircuitBreaker(name = "parcelByLocationCircuitBreaker", fallbackMethod = "getLocationWiseParcelCountFallback")
    @Override
    public List<ParcelByLocation> getLocationWiseParcelCount() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getLocationWiseParcelCountRequest");

        ResponseEntity<ParcelByLocation[]> response = restTemplate.getForEntity(endpointForLocations, ParcelByLocation[].class);

        LOGGER.info("getLocationWiseParcelCountResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(response));

        return Arrays.asList(response.getBody());
    }

    @Override
    public List<Parcel> getAllParcels() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getAllParcelsRequest");

        List<Parcel> parcels =  parcelRepository.findAllParcels();

        LOGGER.info("getAllParcelsResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcels));

        return parcels;
    }

    public List<ParcelByCompany> getCompanyWiseParcelCountFallback(Exception e) throws Exception{
        // Fallback implementation
        return Collections.emptyList();
    }

    public List<ParcelByLocation> getLocationWiseParcelCountFallback(Exception e) throws Exception{
        // Fallback implementation
        return Collections.emptyList();
    }

}
