package com.example.company.controller;

import com.example.company.entity.ParcelByCompany;
import com.example.company.service.CompanyService;
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
class CompanyControllerTest {

    @Mock
    private CompanyService companyService;

    @InjectMocks
    private CompanyController companyController;

    private MockMvc mockMvc;

    @Test
    void testFindParcels() throws Exception {
        List<ParcelByCompany> parcelByCompanies = Arrays.asList(new ParcelByCompany(1,"Digiratina"), new ParcelByCompany(2,"Virtusa"));
        Mockito.when(companyService.getAllParcelsByCompanies()).thenReturn(parcelByCompanies);
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();

        mockMvc.perform(get("/api/companies/get"))
                .andExpect(status().isOk());

        assertEquals(parcelByCompanies, companyController.findAllParcelsByCompanies());
    }

}