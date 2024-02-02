package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.domain.WaterTariff;

import java.util.List;

public interface StandardBillStorage {
    public void load(String filePath);

    List<WaterTariff> searchOptimalBill(int waterVolume);
}
