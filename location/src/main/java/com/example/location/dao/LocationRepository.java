package com.example.location.dao;

import com.example.location.entity.ParcelCountByLocation;

import java.util.List;

public interface LocationRepository {

    List<ParcelCountByLocation> getAllLocations();
}
