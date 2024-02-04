package com.nhnacademy.edu.springframework.parser.impl;

import com.nhnacademy.edu.springframework.domain.WaterTariff;
import com.nhnacademy.edu.springframework.parser.DataParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service("csvDataParser")
public class CsvDataParser implements DataParser {
    @Override
    public Collection<WaterTariff> parse(String filePath) {
        try(InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filePath)));
            BufferedReader br = new BufferedReader(reader)){
            List<WaterTariff> parsedDatas = new ArrayList<>();
            String line = "";
            while ((line = br.readLine())!=null){
                String[] readArgs = line.split(",".trim());
                try{
                    parsedDatas.add(new WaterTariff(Integer.parseInt(readArgs[0]),readArgs[1],readArgs[2],Integer.parseInt(readArgs[3]),
                            Integer.parseInt(readArgs[4]),Integer.parseInt(readArgs[5]),Integer.parseInt(readArgs[6])));

                }catch (NumberFormatException e){
                    log.info("csv 형식이 맞지않아 건너뛰고 작업 합니다!");
                    continue;
                    //Todo 형식에 맞지 않은 정보가 추가되면 추가하지 않고 continue 호출해서 추가하지 않으면서 다음거 해
                }
            }
            return parsedDatas;
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
