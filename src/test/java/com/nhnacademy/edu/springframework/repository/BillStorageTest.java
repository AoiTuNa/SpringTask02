package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.configuration.MainConfig;
import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.factory.ParserFactory;
import com.nhnacademy.edu.springframework.parser.DataParser;
import com.nhnacademy.edu.springframework.parser.impl.CsvDataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(classes = MainConfig.class)
public class BillStorageTest {

    @Autowired
    private ParserFactory parserFactory;
    @Autowired
    private StandardBillStorage standardBillStorage;

    @Test
    public void CsvParserTest(){
        standardBillStorage.load("data/Test_Tariff.csv");
        Assertions.assertEquals(standardBillStorage.findAll().size(),10);
    }
    @Test
    public void searchOptimalBillTest(){
        standardBillStorage.load("data/Test_Tariff.csv");
        List<WaterTariff>test = standardBillStorage.searchOptimalBill(1000);
        Assertions.assertEquals(test.size(),4);
    }

}
