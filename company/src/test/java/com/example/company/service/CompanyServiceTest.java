package com.example.company.service;

import com.example.company.dao.CompanyRepository;
import com.example.company.entity.ParcelByCompany;
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
class CompanyServiceTest {

    @Autowired
    private CompanyService service;

    @MockBean
    private CompanyRepository repository;

    @Test
    public void getParcelsTest(){

        Mockito.when(repository.countParcelsByLocation()).thenReturn(Stream.of(new ParcelByCompany(1,"Digiratina"), new ParcelByCompany(2,"Virtusa")).collect(Collectors.toList()));
        assertEquals(2, service.getCompanyWiseParcelCount().size());

    }

}