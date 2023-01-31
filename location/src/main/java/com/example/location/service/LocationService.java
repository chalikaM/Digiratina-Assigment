package com.example.location.service;

import com.example.location.entity.ParcelCountByLocation;

import java.util.List;

public interface LocationService {

    List<ParcelCountByLocation> getAllParcelsByLocation();
}
