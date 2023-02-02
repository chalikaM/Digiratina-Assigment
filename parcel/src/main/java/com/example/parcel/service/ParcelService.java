package com.example.parcel.service;

import com.example.parcel.entity.Parcel;
import com.example.parcel.entity.ParcelByCompany;
import com.example.parcel.entity.ParcelByLocation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParcelService {

    List<ParcelByCompany> getCompanyWiseParcelCount();

    List<ParcelByLocation> getLocationWiseParcelCount();

    List<Parcel> getAllParcels();


}
