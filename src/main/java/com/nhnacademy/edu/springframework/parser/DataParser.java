package com.nhnacademy.edu.springframework.parser;

import com.nhnacademy.edu.springframework.domain.WaterTariff;

import java.util.Collection;

public interface DataParser {
    public Collection<WaterTariff> parse(String filePath);
}
