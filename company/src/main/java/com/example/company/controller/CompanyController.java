package com.example.company.controller;

import com.example.company.entity.ParcelByCompany;
import com.example.company.service.CompanyService;
import com.example.company.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private static final Logger LOGGER= LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyService service;

    @GetMapping()
    public List<ParcelByCompany> getParcelCountByCompany(){

        long startTime = System.currentTimeMillis();
        LOGGER.info("getParcelCountByCompanyRequest");

        List<ParcelByCompany> parcelsByCompanies = service.getCompanyWiseParcelCount();

        LOGGER.info("getParcelCountByCompanyResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByCompanies));

        return  parcelsByCompanies;

    }
}
