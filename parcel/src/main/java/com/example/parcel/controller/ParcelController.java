package com.example.parcel.controller;

import com.example.parcel.dao.ParcelRepository;
import com.example.parcel.entity.Parcel;
import com.example.parcel.entity.ParcelByCompany;
import com.example.parcel.entity.ParcelByLocation;
import com.example.parcel.service.ParcelService;
import com.example.parcel.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/parcels")
public class ParcelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParcelController.class);

    @Autowired
    ParcelRepository parcelRepository;

    @Autowired
    ParcelService service;

    @PostMapping("/create")
    public void addParcel(@RequestBody Parcel parcel){

        long startTime = System.currentTimeMillis();
        LOGGER.info("addParcelRequest");

        parcelRepository.saveParcel(parcel);

        LOGGER.info("addParcelResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));

    }

    @GetMapping("/companies")
    public List<ParcelByCompany> getParcelCountByCompany() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getParcelCountByCompanyRequest");

        List<ParcelByCompany> parcelsByCompanies = service.getCompanyWiseParcelCount();

        LOGGER.info("getParcelCountByCompanyResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByCompanies));

        return parcelsByCompanies;
    }

    @GetMapping("/locations")
    public List<ParcelByLocation> getParcelCountByLocation() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getParcelCountByLocationRequest");

        List<ParcelByLocation> parcelsByLocations = service.getLocationWiseParcelCount();

        LOGGER.info("getParcelCountByLocationResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByLocations));

        return parcelsByLocations;
    }

    @GetMapping()
    public List<Parcel> listAllParcels(){

        long startTime = System.currentTimeMillis();
        LOGGER.info("listAllParcelsRequest");

        List<Parcel> parcels = service.getAllParcels();

        LOGGER.info("listAllParcelsResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcels));

        return parcels;
    }
}
