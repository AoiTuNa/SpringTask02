package com.nhnacademy.edu.springframework.repository.impl;

import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.repository.StandardBillStorage;

import java.util.List;

public class BillStorage implements StandardBillStorage {
    @Override
    public void load(String filePath) {

    }

    @Override
    public List<WaterTariff> searchOptimalBill(int waterVolume) {
        return null;
    }
}
