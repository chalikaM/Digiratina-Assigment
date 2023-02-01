package com.example.parcel.controller;

import com.example.parcel.entity.Parcel;
import com.example.parcel.entity.ParcelByCompany;
import com.example.parcel.entity.ParcelByLocation;
import com.example.parcel.service.ParcelService;
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
class ParcelControllerTest {

    @Mock
    private ParcelService parcelService;

    @InjectMocks
    private ParcelController parcelController;

    private MockMvc mockMvc;

    @Test
    void testFindParcels() throws Exception {
        List<Parcel> parcels = Arrays.asList(new Parcel(1,"Chalika","Mihiran",1,1), new Parcel(2,"Asiri","Mevan",2,2));
        Mockito.when(parcelService.getAllParcels()).thenReturn(parcels);
        mockMvc = MockMvcBuilders.standaloneSetup(parcelController).build();

        mockMvc.perform(get("/api/assignment/get/parcels"))
                .andExpect(status().isOk());

        assertEquals(parcels, parcelController.findParcels());
    }

    @Test
    void testFindParcelsByCompany() throws Exception {
        List<ParcelByCompany> parcelByCompanies = Arrays.asList(new ParcelByCompany(1,"Digiratina"), new ParcelByCompany(2,"Virtusa"));
        Mockito.when(parcelService.getParcelByCompany()).thenReturn(parcelByCompanies);
        mockMvc = MockMvcBuilders.standaloneSetup(parcelController).build();

        mockMvc.perform(get("/api/assignment/get/companies"))
                .andExpect(status().isOk());

        assertEquals(parcelByCompanies, parcelController.findParcelsByCompany());
    }

    @Test
    void testFindParcelsByLocation() throws Exception {
        List<ParcelByLocation> parcelByLocations = Arrays.asList(new ParcelByLocation(1,"Nugegoda"), new ParcelByLocation(2,"Homagama"));
        Mockito.when(parcelService.getParcelByLocation()).thenReturn(parcelByLocations);
        mockMvc = MockMvcBuilders.standaloneSetup(parcelController).build();

        mockMvc.perform(get("/api/assignment/get/locations"))
                .andExpect(status().isOk());

        assertEquals(parcelByLocations, parcelController.findParcelsByLocation());
    }

}