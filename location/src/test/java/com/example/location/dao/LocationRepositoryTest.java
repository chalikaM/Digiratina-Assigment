package com.example.location.dao;

import com.example.location.dao.impl.LocationRepositoryImpl;
import com.example.location.entity.ParcelCountByLocation;
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
class LocationRepositoryTest {

    @InjectMocks
    private LocationRepositoryImpl locationRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    void testGetAllCompanies() {
        List<ParcelCountByLocation> expectedLocations = Stream.of(new ParcelCountByLocation(1,"Nugegoda"), new ParcelCountByLocation(2,"Homagama")).collect(Collectors.toList());

        Mockito.when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
                .thenReturn(expectedLocations);

        List<ParcelCountByLocation> companies = locationRepository.getAllLocations();

        assertEquals(expectedLocations, companies);
    }

}