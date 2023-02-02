package com.example.location.service;

import com.example.location.dao.LocationRepository;
import com.example.location.entity.Location;
import com.example.location.entity.ParcelCountByLocation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LocationServiceTest {

    @Autowired
    private LocationService service;

    @MockBean
    private LocationRepository repository;

    @Test
    public void testGetLocationWiseParcelCount(){

        Mockito.when(repository.countParcelsByLocation()).thenReturn(Stream.of(new ParcelCountByLocation(1,"Nugegoda"), new ParcelCountByLocation(2,"Homagama")).collect(Collectors.toList()));
        assertEquals(2, service.getLocationWiseParcelCount().size());

    }


}