package com.example.location.dao.impl;

import com.example.location.dao.LocationRepository;
import com.example.location.entity.ParcelCountByLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ParcelCountByLocation> getAllLocations() {

        String selectQuery = "SELECT COUNT(l.id) as parcel_count, l.location_name FROM public.locations l INNER JOIN public.parcels p ON l.id=p.location_id GROUP BY l.id;";

        return jdbcTemplate.query(selectQuery, (rs, rowNum) -> new ParcelCountByLocation(rs.getLong("parcel_count"), rs.getString("location_name")));
    }
}
