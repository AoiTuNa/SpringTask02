package com.nhnacademy.edu.springframework.repository.impl;

import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.factory.ParserFactory;
import com.nhnacademy.edu.springframework.parser.DataParser;
import com.nhnacademy.edu.springframework.repository.StandardBillStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billStorage")
public class BillStorage implements StandardBillStorage {
    private List<WaterTariff> tariffData;
    private final ParserFactory parserFactory;

    @Autowired
    public BillStorage(ParserFactory parserFactory){
        this.parserFactory = parserFactory;
    }
    @Override
    public void load(String filePath) {
        DataParser parser = parserFactory.getParser(filePath);
        tariffData = (List<WaterTariff>) parser.parse(filePath);
    }

    @Override
    public List<WaterTariff> findAll() {
        return tariffData;
    }

    @Override
    public List<WaterTariff> searchOptimalBill(int waterVolume) {
        return findAll();
    }
}
