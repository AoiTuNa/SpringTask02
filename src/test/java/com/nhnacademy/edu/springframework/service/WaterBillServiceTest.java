package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.configuration.MainConfig;
import com.nhnacademy.edu.springframework.domain.WaterBill;
import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.repository.StandardBillStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(classes = MainConfig.class)
public class WaterBillServiceTest {

    @Autowired
    private StandardBillStorage standardBillStorage;
    @Autowired
    private StandardWaterBillService standardWaterBillService;

    @Test
    public void CalculatedTest(){
        standardBillStorage.load("data/Test_Tariff.csv");
        List<WaterBill>testBill = standardWaterBillService.calculated(1000);
        Assertions.assertEquals(testBill.size(),4);

    }

}
