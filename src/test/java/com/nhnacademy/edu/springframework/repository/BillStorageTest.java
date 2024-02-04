package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.configuration.MainConfig;
import com.nhnacademy.edu.springframework.factory.ParserFactory;
import com.nhnacademy.edu.springframework.parser.DataParser;
import com.nhnacademy.edu.springframework.parser.impl.CsvDataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = MainConfig.class)
public class BillStorageTest {

    @Autowired
    private ParserFactory parserFactory;
    @Autowired
    private StandardBillStorage standardBillStorage;

    @Test
    public void CsvParserTest(){
        DataParser dataParser = parserFactory.getParser("data/Test_Tariff.csv");
        Assertions.assertEquals(CsvDataParser.class,dataParser.getClass());
        standardBillStorage.load("data/Test_Tariff.csv");
        Assertions.assertEquals(standardBillStorage.findAll().size(),10);
    }
}
