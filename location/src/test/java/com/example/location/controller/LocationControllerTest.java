package com.example.location.controller;

import com.example.location.entity.ParcelCountByLocation;
import com.example.location.service.LocationService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class LocationControllerTest {

    @Mock
    private LocationService locationService;

    @InjectMocks
    private LocationController locationController;

    private MockMvc mockMvc;

    @Test
    void testGetParcelCountByLocation() throws Exception {
        List<ParcelCountByLocation> parcelCountByLocations = Arrays.asList(new ParcelCountByLocation(1,"Nugegoda"), new ParcelCountByLocation(2,"Homagama"));
        Mockito.when(locationService.getLocationWiseParcelCount()).thenReturn(parcelCountByLocations);
        mockMvc = MockMvcBuilders.standaloneSetup(locationController).build();

        mockMvc.perform(get("/api/v1/locations"))
                .andExpect(status().isOk());

        assertEquals(parcelCountByLocations, locationController.getParcelCountByLocation());
    }

}