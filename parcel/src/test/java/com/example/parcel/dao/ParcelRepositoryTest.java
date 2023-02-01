package com.example.parcel.dao;

import com.example.parcel.dao.impl.ParcelRepositoryImpl;
import com.example.parcel.entity.Parcel;
import com.example.parcel.service.impl.ParcelServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class ParcelRepositoryTest {

    @InjectMocks
    private ParcelRepositoryImpl parcelRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    void testGetAllCompanies() {

        List<Parcel> expectedParcels = Stream.of(new Parcel(1,"Chalika","Mihiran",1,1), new Parcel(2,"Asiri","Mevan",2,2)).collect(Collectors.toList());
        Mockito.when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
                .thenReturn(expectedParcels);

        List<Parcel> companies = parcelRepository.getAllParcels();

        assertEquals(expectedParcels, companies);
    }

}