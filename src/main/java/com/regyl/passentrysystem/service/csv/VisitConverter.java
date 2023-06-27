package com.regyl.passentrysystem.service.csv;

import com.regyl.passentrysystem.api.CsvEntityConverter;
import com.regyl.passentrysystem.model.VisitRecord;
import com.regyl.passentrysystem.model.servicetypes.CsvConverter;
import org.springframework.stereotype.Service;

@Service
public class VisitConverter implements CsvEntityConverter<VisitRecord> {

    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public CsvConverter getType() {
        return CsvConverter.VISIT;
    }

    @Override
    public String convert(VisitRecord obj) {
        return obj.getFormattedVisitTime();
    }
}
