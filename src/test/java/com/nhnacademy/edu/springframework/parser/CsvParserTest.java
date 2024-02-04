package com.nhnacademy.edu.springframework.parser;

import com.nhnacademy.edu.springframework.configuration.MainConfig;
import com.nhnacademy.edu.springframework.domain.WaterTariff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(classes = MainConfig.class)
public class CsvParserTest {

    @Qualifier("csvDataParser")
    @Autowired
    private DataParser dataParser;
    @Test
    public void parse(){
        List<WaterTariff> parsedData = (List<WaterTariff>) dataParser.parse("data/Test_Tariff.csv");
        Assertions.assertEquals(parsedData.size(),10);
    }

}
