package com.example.airportrestfulapi.converter;

import com.example.airportrestfulapi.model.Status;
import org.springframework.core.convert.converter.Converter;

/*
 * Custom controller (String -> to Status enum)
 * */
public class StringToEnumConverter implements Converter<String, Status> {
    @Override
    public Status convert(String source) {
        return Status.valueOf(source.toUpperCase());
    }
}