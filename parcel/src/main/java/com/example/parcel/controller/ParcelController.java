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
@RequestMapping("/api/assignment")
public class ParcelController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParcelController.class);

    @Autowired
    ParcelRepository parcelRepository;

    @Autowired
    ParcelService parcelService;

    @PostMapping("/create")
    public void addParcel(@RequestBody Parcel parcel){

        long startTime = System.currentTimeMillis();
        LOGGER.info("addParcelRequest");

        parcelRepository.saveParcel(parcel);

        LOGGER.info("addParcelResponse : timeTaken={}", CommonUtil.getTimeTaken(startTime));

    }

    @GetMapping("/get/companies")
    public List<ParcelByCompany> findParcelsByCompany() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("findParcelsByCompanyRequest");

        List<ParcelByCompany> parcelsByCompanies = parcelService.getParcelByCompany();

        LOGGER.info("findParcelsByCompanyResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByCompanies));

        return parcelsByCompanies;
    }

    @GetMapping("/get/locations")
    public List<ParcelByLocation> findParcelsByLocation() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("findParcelsByLocationRequest");

        List<ParcelByLocation> parcelsByLocations = parcelService.getParcelByLocation();

        LOGGER.info("findParcelsByLocationResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByLocations));

        return parcelsByLocations;
    }

    @GetMapping("/get/parcels")
    public List<Parcel> findParcels(){

        long startTime = System.currentTimeMillis();
        LOGGER.info("findParcelsRequest");

        List<Parcel> parcels = parcelService.getAllParcels();

        LOGGER.info("findParcelsResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcels));

        return parcels;
    }
}
