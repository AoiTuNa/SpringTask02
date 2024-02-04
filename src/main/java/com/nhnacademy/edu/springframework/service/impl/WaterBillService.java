package com.nhnacademy.edu.springframework.service.impl;

import com.nhnacademy.edu.springframework.domain.WaterBill;
import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.repository.StandardBillStorage;
import com.nhnacademy.edu.springframework.service.StandardWaterBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("waterBillService")
public class WaterBillService implements StandardWaterBillService {

    @Autowired
    private StandardBillStorage billStorage;
    @Override
    public List<WaterBill> calculated(int waterVolume) {
        List<WaterTariff> tariffs = billStorage.searchOptimalBill(waterVolume);
        List<WaterBill> waterBills = new ArrayList<>();
        for (WaterTariff tariff : tariffs) {
            waterBills.add(new WaterBill(tariff.getGovernment(),tariff.getUsage(),tariff.getSectorBill(),waterVolume*tariff.getSectorBill()));
        }
        return waterBills.stream()
                .sorted(Comparator.comparingInt(WaterBill::getBillTotal))
                .limit(5)
                .collect(Collectors.toList());
    }
}
