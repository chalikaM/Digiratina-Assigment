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
    private ParcelService service;

    @InjectMocks
    private ParcelController controller;

    private MockMvc mockMvc;

    @Test
    void testListAllParcels() throws Exception {
        List<Parcel> parcels = Arrays.asList(new Parcel(1,"Chalika","Mihiran",1,1), new Parcel(2,"Asiri","Mevan",2,2));
        Mockito.when(service.getAllParcels()).thenReturn(parcels);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/parcels"))
                .andExpect(status().isOk());

        assertEquals(parcels, controller.listAllParcels());
    }

    @Test
    void testGetParcelCountByCompany() throws Exception {
        List<ParcelByCompany> parcelByCompanies = Arrays.asList(new ParcelByCompany(1,"Digiratina"), new ParcelByCompany(2,"Virtusa"));
        Mockito.when(service.getCompanyWiseParcelCount()).thenReturn(parcelByCompanies);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/parcels/companies"))
                .andExpect(status().isOk());

        assertEquals(parcelByCompanies, controller.getParcelCountByCompany());
    }

    @Test
    void testGetParcelCountByLocation() throws Exception {
        List<ParcelByLocation> parcelByLocations = Arrays.asList(new ParcelByLocation(1,"Nugegoda"), new ParcelByLocation(2,"Homagama"));
        Mockito.when(service.getLocationWiseParcelCount()).thenReturn(parcelByLocations);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/parcels/companies"))
                .andExpect(status().isOk());

        assertEquals(parcelByLocations, controller.getParcelCountByLocation());
    }

}