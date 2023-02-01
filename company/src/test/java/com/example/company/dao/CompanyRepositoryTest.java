package com.example.company.dao;

import com.example.company.dao.impl.CompanyRepositoryImpl;
import com.example.company.entity.ParcelByCompany;
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
class CompanyRepositoryTest {

    @InjectMocks
    private CompanyRepositoryImpl companyRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    void testGetAllCompanies() {
        List<ParcelByCompany> expectedCompanies = Stream.of(new ParcelByCompany(1,"Digiratina"), new ParcelByCompany(2,"Virtusa")).collect(Collectors.toList());

        Mockito.when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
                .thenReturn(expectedCompanies);

        List<ParcelByCompany> companies = companyRepository.getAllCompanies();

        assertEquals(expectedCompanies, companies);
    }

}