package com.example.parcel.service;

import com.example.parcel.dao.ParcelRepository;
import com.example.parcel.entity.Parcel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ParcelServiceTest {

    @Autowired
    private ParcelService service;

    @MockBean
    private ParcelRepository repository;

    @Test
    public void testGetAllParcels(){

        Mockito.when(repository.findAllParcels()).thenReturn(Stream.of(new Parcel(1,"Chalika","Mihiran",1,1), new Parcel(2,"Asiri","Mevan",2,2)).collect(Collectors.toList()));
        assertEquals(2, service.getAllParcels().size());

    }



}