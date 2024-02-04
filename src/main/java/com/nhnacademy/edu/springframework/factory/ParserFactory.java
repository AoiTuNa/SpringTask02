package com.nhnacademy.edu.springframework.factory;

import com.nhnacademy.edu.springframework.parser.DataParser;
import com.nhnacademy.edu.springframework.parser.impl.CsvDataParser;
import com.nhnacademy.edu.springframework.parser.impl.JsonDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ParserFactory {

    private final CsvDataParser csvDataParser;
    private final JsonDataParser jsonDataParser;

    @Autowired
    public ParserFactory(@Qualifier("csvDataParser") CsvDataParser csvDataParser,
                         @Qualifier("jsonDataParser") JsonDataParser jsonDataParser){
        this.csvDataParser = csvDataParser;
        this.jsonDataParser = jsonDataParser;
    }

    public DataParser getParser(String filePath){
        if(filePath.endsWith(".csv")){
            return csvDataParser;
        } else if (filePath.endsWith(".json")) {
            return jsonDataParser;
        } else {
            throw new IllegalArgumentException("Unsupported file Type!!");
        }
    }
}
