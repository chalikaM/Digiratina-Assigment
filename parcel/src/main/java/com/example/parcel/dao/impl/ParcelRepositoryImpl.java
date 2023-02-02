package com.example.parcel.dao.impl;
import com.example.parcel.dao.ParcelRepository;
import com.example.parcel.entity.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParcelRepositoryImpl implements ParcelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveParcel(Parcel parcel) {

        StringBuilder insert = new StringBuilder();
        insert.append("INSERT INTO \"parcels\" (");
        insert.append("reciver_name,");
        insert.append("sender_name,");
        insert.append("company_id,");
        insert.append("location_id");
        insert.append(") ");
        insert.append("VALUES (");
        insert.append("?, ?, ?, ?");
        insert.append(") ");

        String insertQuery = insert.toString();
        jdbcTemplate.update(insertQuery, parcel.getReceiverName(), parcel.getSenderName(), parcel.getCompanyId(), parcel.getLocationId());

    }

    @Override
    public List<Parcel> findAllParcels() {

        String selectQuery = "SELECT * FROM parcels;";

        return jdbcTemplate.query(selectQuery, (rs, rowNum) -> new Parcel(rs.getLong("id"), rs.getString("sender_name"), rs.getString("reciver_name"), rs.getLong("location_id"), rs.getLong("company_id")));
    }
}
