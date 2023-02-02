package com.example.company.service;

import com.example.company.entity.ParcelByCompany;

import java.util.List;

public interface CompanyService {

    List<ParcelByCompany> getCompanyWiseParcelCount();
}
