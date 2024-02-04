package com.nhnacademy.edu.springframework.parser.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.parser.DataParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service("jsonDataParser")
public class JsonDataParser implements DataParser {
    @Override
    public List<WaterTariff> parse(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<WaterTariff> waterTariffList = null;

        try (InputStream inputStream = new ClassPathResource(filePath).getInputStream()) {
            waterTariffList = objectMapper.readValue(inputStream, new TypeReference<List<WaterTariff>>() {});
        } catch (IOException e) {
            throw new RuntimeException();
        }

        return waterTariffList;
    }
}