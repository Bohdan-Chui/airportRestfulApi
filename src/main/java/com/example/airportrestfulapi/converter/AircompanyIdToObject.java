package com.example.airportrestfulapi.converter;

import com.example.airportrestfulapi.model.AirCompany;
import com.example.airportrestfulapi.service.AirCompanyService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Custom controller (aircompanyId -> to aircompany object)
 * */
@Component
public class AircompanyIdToObject implements org.springframework.core.convert.converter.Converter<Integer, AirCompany>,
        com.fasterxml.jackson.databind.util.Converter<Integer,AirCompany> {

    private final AirCompanyService airCompanyService;

    @Autowired
    public AircompanyIdToObject(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @Override
    public AirCompany convert(Integer source) {
        return airCompanyService.getCompany(source);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructType(Integer.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructType(AirCompany.class);
    }

}
