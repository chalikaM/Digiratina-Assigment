package com.example.company.dao.impl;

import com.example.company.dao.CompanyRepository;
import com.example.company.entity.ParcelByCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ParcelByCompany> countParcelsByLocation() {

        String selectQuery = "SELECT COUNT(c.id) as parcel_count, c.company_name FROM public.companies c INNER JOIN public.parcels p ON c.id=p.company_id GROUP BY c.id;";

        return jdbcTemplate.query(selectQuery, (rs, rowNum) -> new ParcelByCompany(rs.getLong("parcel_count"), rs.getString("company_name")));
    }
}
