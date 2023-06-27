package com.regyl.passentrysystem.service.csv;

import com.regyl.passentrysystem.api.CsvBuilder;
import com.regyl.passentrysystem.api.CsvEntityConverter;
import com.regyl.passentrysystem.exception.PassEntrySystemException;
import com.regyl.passentrysystem.model.servicetypes.CsvConverter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class CsvBuilderImpl implements CsvBuilder {

    private final Map<CsvConverter, CsvEntityConverter> csvEntityConverterMap;

    public CsvBuilderImpl(Collection<CsvEntityConverter> csvEntityConverterCollection) {
        this.csvEntityConverterMap = csvEntityConverterCollection.stream()
                .collect(Collectors.toMap(CsvEntityConverter::getType, Function.identity()));
    }

    @Override
    public String convertToCsv(CsvConverter converterType, List<?> objects) {
        CsvEntityConverter converter = csvEntityConverterMap.get(converterType);
        if (converter == null) {
            throw new PassEntrySystemException("Отсутствует сервис для конвертации типа " + converterType);
        }

        StringBuilder sb = new StringBuilder(converter.getHeader());
        for (Object obj : objects) {
            sb.append(System.lineSeparator()).append(converter.convert(obj));
        }

        return sb.toString();
    }
}
