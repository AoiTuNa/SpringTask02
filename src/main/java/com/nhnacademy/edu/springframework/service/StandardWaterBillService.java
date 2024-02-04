package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.domain.WaterBill;

import java.util.List;

public interface StandardWaterBillService {
    public List<WaterBill> calculated(int waterVolume);
}
