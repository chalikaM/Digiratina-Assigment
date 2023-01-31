package com.example.company.dao;

import com.example.company.entity.ParcelByCompany;

import java.util.List;

public interface CompanyRepository {

    List<ParcelByCompany> getAllCompanies();
}
