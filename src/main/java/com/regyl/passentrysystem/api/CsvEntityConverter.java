package com.regyl.passentrysystem.api;

import com.regyl.passentrysystem.model.servicetypes.CsvConverter;

public interface CsvEntityConverter<T> {

    String getHeader();

    CsvConverter getType();

    String convert(T obj);
}
