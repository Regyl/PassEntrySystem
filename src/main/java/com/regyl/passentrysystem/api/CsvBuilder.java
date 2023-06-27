package com.regyl.passentrysystem.api;

import com.regyl.passentrysystem.model.servicetypes.CsvConverter;

import java.util.List;

public interface CsvBuilder {

    String convertToCsv(CsvConverter converterType, List<?> objects);
}
