package com.nhnacademy.edu.springframework.parser.impl;

import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.parser.DataParser;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("jsonDataParser")
public class JsonDataParser implements DataParser {
    @Override
    public Collection<WaterTariff> parse(String filePath) {

        return null;
    }
}
