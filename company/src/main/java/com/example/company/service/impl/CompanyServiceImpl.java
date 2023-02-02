package com.example.company.service.impl;

import com.example.company.controller.CompanyController;
import com.example.company.dao.CompanyRepository;
import com.example.company.entity.ParcelByCompany;
import com.example.company.service.CompanyService;
import com.example.company.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    CompanyRepository repository;

    @Override
    public List<ParcelByCompany> getCompanyWiseParcelCount() {

        long startTime = System.currentTimeMillis();
        LOGGER.info("getAllParcelsByCompaniesRequest");

        List<ParcelByCompany> parcelsByCompanies = repository.countParcelsByLocation();

        LOGGER.info("getAllParcelsByCompaniesResponse : timeTaken={}|response={}", CommonUtil.getTimeTaken(startTime), CommonUtil.convertToString(parcelsByCompanies));

        return parcelsByCompanies;
    }
}
