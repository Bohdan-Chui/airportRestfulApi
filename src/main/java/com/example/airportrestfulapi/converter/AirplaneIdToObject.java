package com.example.airportrestfulapi.converter;

import com.example.airportrestfulapi.model.Airplane;
import com.example.airportrestfulapi.service.AirplaneService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*
 * Custom controller (airplaneId -> to airplane object)
 * */
public class AirplaneIdToObject implements org.springframework.core.convert.converter.Converter<Integer, Airplane>,
        com.fasterxml.jackson.databind.util.Converter<Integer,Airplane> {

    @Autowired
    private AirplaneService airplaneService;

    @Override
    public Airplane convert(Integer source) {
        return airplaneService.getPlane(source);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(Integer.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(Airplane.class);
    }

}
